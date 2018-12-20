package com.nsu.fit.tests.schukin.testsspringboot.testng.rest

import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.Subscription
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.TestsApi
import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.Customer
import org.testng.annotations.Test

class TestSubscriptionTests {

    private val api = TestsApi("http://localhost:8080/")
    private lateinit var token: String

    private val startCustomerBalance = 50
    private lateinit var createdCustomer: Customer

    private val planFee = 25
    private lateinit var createdPlan: Plan

    private lateinit var createdSubscription: Subscription

    @Test(description = "test login")
    fun testSignIn() {
        api.signIn("lel", "kek")
            .subscribe({
                token = it.token!!
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

    @Test(description = "Test balance top up", priority = 2)
    fun testTopUpBalance() {
        api.topUpBalance(createdCustomer.getId(), startCustomerBalance, token)
            .subscribe ({
                assert(it.balance - createdCustomer.balance == startCustomerBalance)
                createdCustomer = it
            },{
                throw it
            })
    }

    @Test(description = "Test creating customer", priority = 3)
    fun testCreatePlan() {
        val planName = "TestPlan"
        val planDetails = "Test plan details"
        api.createPlan(
            planName, planDetails, planFee,  token
        ).subscribe({
            createdPlan = it
        }, {
            throw it
        })
    }

    @Test(description = "Test creating customer", priority = 4)
    fun testGetPlan() {
        api.getPlan(createdPlan.id!!, token)
            .subscribe({
                assert(createdPlan.id == it.id)
                assert(createdPlan.details == it.details)
                assert(createdPlan.name == it.name)
                assert(createdPlan.fee == it.fee)
            }, {
                throw it
            })
    }

    @Test(description = "Test creating subscription", priority = 5)
    fun testCreateSubscription() {
        api.createSubscription(
            createdCustomer.id!!, createdPlan.id!!, token
        ).subscribe({
            assert(it.customer?.id == createdCustomer.id)
            assert(it.plan?.id == createdPlan.id)
            createdSubscription = it
        }, {
            throw it
        })
    }

    @Test(description = "Test get subscription", priority = 6)
    fun testGetSubscription() {
        api.getSubscription(createdSubscription.id!!, token)
            .subscribe({
                assert(it.plan?.id == createdSubscription.plan?.id)
                assert(it.customer?.id == createdSubscription.customer?.id)
            }, {
                throw it
            })
    }

    @Test(description = "Test customer balance change", priority = 7)
    fun testCustomerBalanceChange() {
        api.getCustomer(createdCustomer.getId(), token)
            .subscribe({
                assert(it.balance == startCustomerBalance - planFee)
                createdCustomer = it
            }, {
                throw it
            })
    }

    @Test(description = "Test customer balance change", priority = 8)
    fun testDeleteSubscription() {
        api.deleteSubscription(createdSubscription.id!!, token)
            .subscribe({}, {
                throw it
            })
    }

    @Test(description = "Test customer balance change", priority = 9)
    fun testDeletePlan() {
        api.deletePlan(createdPlan.id!!, token)
            .subscribe({}, {
                throw it
            })
    }

    @Test(description = "Test customer balance change", priority = 10)
    fun testDeleteCustomer() {
        api.deleteCustomer(createdCustomer.getId(), token)
            .subscribe({}, {
                throw it
            })
    }
}