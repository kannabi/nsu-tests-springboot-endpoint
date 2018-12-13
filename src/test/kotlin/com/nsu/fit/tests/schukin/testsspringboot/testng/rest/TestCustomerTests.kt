package com.nsu.fit.tests.schukin.testsspringboot.testng.rest

import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.ServerApiException
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.TestsApi
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.Customer
import org.testng.annotations.Test
import java.lang.Exception


class TestCustomerTests {

    private val api = TestsApi("http://localhost:8080/")
    private lateinit var token: String
    private lateinit var createdCustomer: Customer

    @Test(description = "test login")
    fun testSignIn() {
        api.signIn("lel", "kek")
            .subscribe({
                token = it.token ?: throw Exception("token is null")
            }, {
                throw it
            })
    }

    @Test(description = "Test creating customer", priority = 1)
    fun testCreateCustomer() {

        val firstName = "Vladimir"
        val lastName = "Ulyanov"
        val login = "xXx_LENIN_xXx@kremlin.com"
        val password = "LeninAlive"

        api.createCustomer(
            firstName, lastName, login, password, token
        ).subscribe({
            assert(firstName == it.firstName)
            assert(lastName == it.lastName)
            assert(login == it.login)
            assert(it.balance == 0)
            createdCustomer = it
        }, {
            throw it
        })
    }

    @Test(description = "Test getting customer", priority = 2)
    fun testGetCustomer() {
        api.getCustomer(createdCustomer.getId(), token)
            .subscribe( {
                assert(it == createdCustomer)
            }, {
                throw it
            })
    }

    @Test(description = "Test user updating", priority = 3)
    fun testUpdateCustomer() {
        val newName = "Volodya"
        api.updateCustomer(
            id = createdCustomer.getId(),
            token = token,
            firstName = newName
        ).subscribe ({
            assert(newName == it.firstName)
            assert(createdCustomer.lastName == it.lastName)
            assert(createdCustomer.login == it.login)
            assert(createdCustomer.balance == it.balance)
            createdCustomer = it
        },{
            throw it
        })
    }

    @Test(description = "Test balance top up", priority = 4)
    fun testTopUpBalance() {
        val incoming = 50
        api.topUpBalance(createdCustomer.getId(), incoming, token)
            .subscribe ({
                assert(it.balance - createdCustomer.balance == 50)
                createdCustomer = it
            },{
                throw it
            })
    }

    @Test(description = "Test getting all users", priority = 5)
    fun testGettingAll() {
        api.getAllCustomers(token)
            .subscribe ({
                assert(it.contains(createdCustomer))
            },{
                throw it
            })
    }

//    @Test(description = "Test user deleting", priority = 6, expectedExceptions = [ServerApiException::class])
    @Test(description = "Test user deleting", priority = 6)
    fun testDeleting() {
        api.deleteCustomer(createdCustomer.getId(), token)
            .flatMap { api.getCustomer(createdCustomer.getId(), token) }
            .subscribe({}, {
                assert(it is ServerApiException)
                assert((it as ServerApiException).code == 404)
            })
    }
}