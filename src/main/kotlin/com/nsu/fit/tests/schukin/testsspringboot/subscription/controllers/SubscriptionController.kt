package com.nsu.fit.tests.schukin.testsspringboot.subscription.controllers

import com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.requests.CreateSubscriptionRequest
import com.nsu.fit.tests.schukin.testsspringboot.subscription.exceptions.CustomerIdIsNull
import com.nsu.fit.tests.schukin.testsspringboot.subscription.exceptions.PlanIdIsNull
import com.nsu.fit.tests.schukin.testsspringboot.subscription.services.SubscriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/subscription")
class SubscriptionController
@Autowired constructor(
    private val subscriptionService: SubscriptionService
){
    @PostMapping()
    @ResponseBody
    fun createSubscription(@RequestBody request: CreateSubscriptionRequest) =
        ResponseEntity(
            subscriptionService.createSubscription(
                request.customerId ?: throw CustomerIdIsNull(),
                request.planId ?: throw PlanIdIsNull()
            ),
            HttpStatus.OK
        )

    @GetMapping("/{id}")
    @ResponseBody
    fun getSubscriptionById(@PathVariable("id") id: String) =
        ResponseEntity(
            subscriptionService.getSubscriptionById(id),
            HttpStatus.OK
        )

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteSubscription(@PathVariable("id") id: String) =
        ResponseEntity(
            subscriptionService.removeSubscription(id),
            HttpStatus.OK
        )
}