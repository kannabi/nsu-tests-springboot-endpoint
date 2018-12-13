package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin

import com.fasterxml.jackson.annotation.JsonProperty

class AdminSignRequest (
    @field:JsonProperty("login")
    var login: String? = null,

    @field:JsonProperty("password")
    var password: String? = null
)