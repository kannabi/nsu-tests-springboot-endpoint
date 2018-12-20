package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.requests.CreatePlanRequest
import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.Subscription
import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.requests.CreateSubscriptionRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.ErrorResponse
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin.AdminSignInResponse
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin.AdminSignRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.Customer
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests.CreateCustomerRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests.TopUpBalanceRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests.UpdateCustomerRequest
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.*
import java.nio.charset.Charset

class TestsApi(
    baseUrl: String
) {

    private val controller by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor (getTestApiInterceptor())
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitController::class.java)
    }

    fun signIn(login: String, password: String) =
        controller.signIn(
            AdminSignRequest(login, password)
        ).map {
            AdminSignInResponse(
                wrapToken(it.token ?: throw Exception("token is null")),
                it.admin
            )
        }

    fun createCustomer(
        firstName: String, lastName: String,
        login: String, password: String,
        token: String
    ) =
        controller.createCustomer(
            CreateCustomerRequest(
                firstName, lastName, login, password
            ),
            token
        )

    fun getCustomer(id: String, token: String) =
        controller.getCustomer(id, token)

    fun getAllCustomers(token: String) =
        controller.getCustomers(token)

    fun updateCustomer(
        id: String, token: String,
        firstName: String? = null,
        lastName: String? = null,
        login: String? = null,
        password: String? = null
    ) =
        controller.updateCustomer(
            id, token,
            UpdateCustomerRequest(
                firstName, lastName, login, password
            )
        )

    fun topUpBalance(id: String, incoming: Int, token: String) =
        controller.topUpBalance(id, token, TopUpBalanceRequest(incoming))

    fun deleteCustomer(id: String, token: String) =
        controller.deleteCustomer(id, token)

    fun createPlan(name: String, details: String, fee: Int, token: String) =
        controller.createPlan(
            CreatePlanRequest(name, details, fee),
            token
        )

    fun getPlan(id: String, token: String) =
        controller.getPlan(id, token)

    fun deletePlan(id: String, token: String) =
        controller.deletePlan(id, token)

    fun createSubscription(customerId: String, planId: String, token: String) =
        controller.createSubscription(
            CreateSubscriptionRequest(customerId, planId),
            token
        )

    fun getSubscription(id: String, token: String) =
        controller.getSubscription(id, token)

    fun deleteSubscription(id: String, token: String) =
        controller.deleteSubscription(id, token)

    private interface RetrofitController {

        @POST("/admin/sign-in")
        fun signIn(@Body request: AdminSignRequest): Single<AdminSignInResponse>

        @POST("/customer")
        fun createCustomer(
            @Body request: CreateCustomerRequest,
            @Header("Authorization") token: String
        ): Single<Customer>

        @GET("/customer/{id}")
        fun getCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Customer>

        @GET("/customer/all")
        fun getCustomers(
            @Header("Authorization") token: String
        ): Single<List<Customer>>

        @PUT("/customer/{id}")
        fun updateCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String,
            @Body request: UpdateCustomerRequest
        ): Single<Customer>

        @PUT("/customer/{id}/balance")
        fun topUpBalance(
            @Path("id") id: String,
            @Header("Authorization") token: String,
            @Body request: TopUpBalanceRequest
        ): Single<Customer>

        @DELETE("/customer/{id}")
        fun deleteCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Unit>

        @POST("/plan")
        fun createPlan(
            @Body request: CreatePlanRequest,
            @Header("Authorization") token: String
        ): Single<Plan>

        @GET("/plan/{id}")
        fun getPlan(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Plan>

        @DELETE("/plan/{id}")
        fun deletePlan(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Unit>

        @POST("/subscription")
        fun createSubscription(
            @Body request: CreateSubscriptionRequest,
            @Header("Authorization") token: String
        ): Single<Subscription>

        @GET("/subscription/{id}")
        fun getSubscription(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Subscription>

        @DELETE("/subscription/{id}")
        fun deleteSubscription(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Unit>
    }

    private fun getTestApiInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .build()
            val response = chain.proceed(request)
            if (!response.isSuccessful) {
                val body =
                    response.body()?.bytes()?.toString(Charset.forName("UTF-8"))
                        ?: throw Exception("Empty response body")
                jacksonObjectMapper().readValue<ErrorResponse>(body).apply {
                    throw ServerApiException(
                        message ?: "", status ?: response.code()
                    )
                }
            }
            response
        }

    private fun wrapToken(token: String) = "Bearer $token"
}