package com.nsu.fit.tests.schukin.testsspringboot.customers.dto.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class UpdateCustomerRequest (
    @field:JsonProperty("firstName")
    var firstName: String? = null,

    @field:JsonProperty("lastName")
    var lastName: String? = null,

    @field:JsonProperty("login")
    var login: String? = null,

    @field:JsonProperty("pass")
    var pass: String? = null
)