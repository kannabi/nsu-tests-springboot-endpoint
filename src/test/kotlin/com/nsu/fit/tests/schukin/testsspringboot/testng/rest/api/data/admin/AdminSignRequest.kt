package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin

import com.fasterxml.jackson.annotation.JsonProperty

class AdminSignRequest (
    @JsonProperty("login")
    var login: String? = null,

    @JsonProperty("password")
    var password: String? = null
)