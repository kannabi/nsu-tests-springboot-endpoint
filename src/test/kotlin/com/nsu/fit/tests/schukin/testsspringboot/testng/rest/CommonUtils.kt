package com.nsu.fit.tests.schukin.testsspringboot.testng.rest

import com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.Customer

fun Customer.getId(): String = id ?: throw Exception("Customer data is broken")