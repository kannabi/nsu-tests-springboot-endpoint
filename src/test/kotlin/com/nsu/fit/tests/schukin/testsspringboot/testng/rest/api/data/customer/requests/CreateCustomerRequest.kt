package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class CreateCustomerRequest (

    @JsonProperty("firstName")
    var firstName: String? = null,

    @JsonProperty("lastName")
    var lastName: String? = null,

    @JsonProperty("login")
    var login: String? = null,

    @JsonProperty("pass")
    var pass: String? = null
)