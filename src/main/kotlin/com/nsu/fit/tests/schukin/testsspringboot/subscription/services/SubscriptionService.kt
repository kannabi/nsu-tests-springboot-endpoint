package com.nsu.fit.tests.schukin.testsspringboot.subscription.services

import com.nsu.fit.tests.schukin.testsspringboot.customers.services.CustomerService
import com.nsu.fit.tests.schukin.testsspringboot.plan.exceptions.PlanFeeIsNull
import com.nsu.fit.tests.schukin.testsspringboot.plan.services.PlanService
import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.Subscription
import com.nsu.fit.tests.schukin.testsspringboot.subscription.exceptions.SubscriptionAlreadyExists
import com.nsu.fit.tests.schukin.testsspringboot.subscription.exceptions.SubscriptionNotFound
import com.nsu.fit.tests.schukin.testsspringboot.subscription.repositories.SubscriptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SubscriptionService
@Autowired constructor(
    private val planService: PlanService,
    private val customerService: CustomerService,
    private val subscriptionRepository: SubscriptionRepository
) {

    /**
     * Метод создает подписку. Ограничения:
     * 1. Подписки с таким планом пользователь не имеет.
     * 2. Стоймость подписки не превышает текущего баланса кастомера и после покупки вычитается из его баласа.
     */
    fun createSubscription(customerId: String, planId: String): Subscription {
        val plan = planService.getPlan(planId)
        val customer = customerService.getCustomer(customerId)

        subscriptionRepository.findSubscriptionByCustomerAndPlan(customer, plan)?.let {
            throw SubscriptionAlreadyExists()
        }

        customerService.topDownBalance(customerId, plan.fee ?: throw PlanFeeIsNull())

        return subscriptionRepository.save(
            Subscription(
                plan = plan,
                customer = customer
            )
        )
    }


    fun removeSubscription(id: String) =
        subscriptionRepository.delete(id)

    /**
     * Возвращает список подписок указанного customer'а.
     */
    fun getSubscriptions(customerId: String): List<Subscription> =
        subscriptionRepository.findByCustomerId(customerId)

    fun getSubscriptionById(id: String)=
        subscriptionRepository.findOne(id) ?: throw SubscriptionNotFound()
}
