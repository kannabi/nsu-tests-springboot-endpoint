package com.nsu.fit.tests.schukin.testsspringboot.customers.controllers

import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.Customer
import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.requests.CreateCustomerRequest
import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.requests.UpdateCustomerRequest
import com.nsu.fit.tests.schukin.testsspringboot.customers.services.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController
@Autowired constructor(
    private val customerService: CustomerService
) {

    @PostMapping()
    @ResponseBody
    fun createCustomer(@RequestBody request: CreateCustomerRequest): ResponseEntity<Customer> =
        ResponseEntity(
            customerService.createCustomer(
                request.firstName,
                request.lastName,
                request.login,
                request.pass
            ),
            HttpStatus.CREATED
        )


    @GetMapping("/{id}")
    @ResponseBody
    fun getCustomer(
        @PathVariable("id") id: String,
        @RequestBody request: CreateCustomerRequest
    ): ResponseEntity<Customer> =
        ResponseEntity(
            customerService.getCustomer(id),
            HttpStatus.OK
        )

    @GetMapping("/all")
    @ResponseBody
    fun getCustomers(): ResponseEntity<List<Customer>> =
        ResponseEntity(
            customerService.getCustomers(),
            HttpStatus.OK
        )

    @PutMapping("/{id}")
    @ResponseBody
    fun updateCustomer(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateCustomerRequest
    ): ResponseEntity<Customer> =
        ResponseEntity(
            customerService.updateCustomer(
                request.firstName,
                request.lastName,
                request.login,
                request.pass
            ),
            HttpStatus.OK
        )

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteCustomer(@PathVariable("id") id: String) =
        customerService.removeCustomer(id)


}



