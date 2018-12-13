package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class CreateCustomerRequest (

    @field:JsonProperty("firstName")
    var firstName: String? = null,

    @field:JsonProperty("lastName")
    var lastName: String? = null,

    @field:JsonProperty("login")
    var login: String? = null,

    @field:JsonProperty("pass")
    var pass: String? = null
)