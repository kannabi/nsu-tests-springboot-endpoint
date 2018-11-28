package com.nsu.fit.tests.schukin.testsspringboot.service

import com.nsu.fit.tests.schukin.testsspringboot.dto.Subscription
import org.springframework.stereotype.Service
import java.util.*

@Service
class SubscriptionService {

    /**
     * Метод создает подписку. Ограничения:
     * 1. Подписки с таким планом пользователь не имеет.
     * 2. Стоймость подписки не превышает текущего баланса кастомера и после покупки вычитается из его баласа.
     */
    fun createSubscription(subscription: Subscription): Subscription = TODO()

    fun removeSubscription(subscriptionId: UUID) {
        TODO()
    }

    /**
     * Возвращает список подписок указанного customer'а.
     */
    fun getSubscriptions(customerId: UUID): List<Subscription> = TODO()
}
