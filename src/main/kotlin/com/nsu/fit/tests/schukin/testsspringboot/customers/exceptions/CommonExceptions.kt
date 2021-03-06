package com.nsu.fit.tests.schukin.testsspringboot.customers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer not found")
class CustomerNotFound: IllegalAccessException("Customer not found")

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Incoming balance is wrong")
class BalanceIncomingException: IllegalAccessException("Incoming balance is wrong")

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Not enough money")
class NotEnoughMoney: IllegalAccessException("Not enough money")