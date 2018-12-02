package com.nsu.fit.tests.schukin.testsspringboot.customers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer not found")
class CustomerNotFound: IllegalAccessException("Customer not found")