package com.nsu.fit.tests.schukin.testsspringboot.repositories

import com.nsu.fit.tests.schukin.testsspringboot.dto.Customer
import org.springframework.data.repository.CrudRepository


interface CustomerRepository: CrudRepository<Customer, String>