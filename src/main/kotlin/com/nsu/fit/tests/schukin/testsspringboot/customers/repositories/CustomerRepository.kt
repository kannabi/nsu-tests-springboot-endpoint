package com.nsu.fit.tests.schukin.testsspringboot.customers.repositories

import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.Customer
import org.springframework.data.repository.CrudRepository


interface CustomerRepository: CrudRepository<Customer, String>