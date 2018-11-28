package com.nsu.fit.tests.schukin.testsspringboot.controllers

import com.nsu.fit.tests.schukin.testsspringboot.dto.Response
import com.nsu.fit.tests.schukin.testsspringboot.service.CustomerService
import com.nsu.fit.tests.schukin.testsspringboot.service.PlanService
import com.nsu.fit.tests.schukin.testsspringboot.service.SubscriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RestController
@Autowired constructor(
    private val customerService: CustomerService,
    private val planService: PlanService,
    private val subscriptionService: SubscriptionService

) {

    @GetMapping("/health")
    @ResponseBody
    fun healthCheck() = Response(HttpStatus.OK.value(), "")
}