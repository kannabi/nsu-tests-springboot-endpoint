package com.nsu.fit.tests.schukin.testsspringboot.subscription.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Such subscription already exists")
class SubscriptionAlreadyExists: IllegalAccessException("Such subscription already exists")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer id must be not null")
class CustomerIdIsNull: IllegalAccessException("Customer id must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan id must be not null")
class PlanIdIsNull: IllegalAccessException("Plan id must be not null")

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Subscription not found")
class SubscriptionNotFound: IllegalAccessException("Subscription not found")