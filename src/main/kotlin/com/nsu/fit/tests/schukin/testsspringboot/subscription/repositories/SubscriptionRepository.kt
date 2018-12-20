package com.nsu.fit.tests.schukin.testsspringboot.subscription.repositories

import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.Customer
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.Subscription
import org.springframework.data.repository.CrudRepository

interface SubscriptionRepository: CrudRepository<Subscription, String> {

    fun findSubscriptionByCustomerAndPlan(customer: Customer, plam: Plan): Subscription?

    fun findByCustomerId(customerId: String): List<Subscription>
}