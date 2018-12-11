package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api

import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.responses.AdminSignInResponse
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin.AdminSignRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.Customer
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests.CreateCustomerRequest
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests.UpdateCustomerRequest
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.*

class TestsApi {

    private val controller by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader("Accept", "application/json")
                            .build()
                        chain.proceed(request)
                    }.addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    ).build()
            )
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitController::class.java)
    }

    fun signIn(login: String, password: String) =
        controller.signIn(
            AdminSignRequest(login, password)
        )

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
        firstName: String, lastName: String,
        login: String, password: String
    ) =
        controller.updateCustomer(
            id, token,
            UpdateCustomerRequest(
                firstName, lastName, login, password
            )
        )

    fun deleteCustomer(id: String, token: String) =
        controller.deleteCustomer(id, token)


    private interface RetrofitController {

        @POST("/admin/sign-in")
        fun signIn(@Body request: AdminSignRequest): Single<AdminSignInResponse>

        @POST("/customer")
        fun createCustomer(
            @Body request: CreateCustomerRequest,
            @Header("Authorization") token: String
        ): Single<Customer>

        @GET("/{id}")
        fun getCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Customer>

        @GET("/all")
        fun getCustomers(
            @Header("Authorization") token: String
        ): Single<List<Customer>>

        @PUT("/{id}")
        fun updateCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String,
            @Body request: UpdateCustomerRequest
        ): Single<Customer>

        @DELETE("/{id}")
        fun deleteCustomer(
            @Path("id") id: String,
            @Header("Authorization") token: String
        ): Single<Unit>
    }
}