package com.nsu.fit.tests.schukin.testsspringboot.dto.requests

import com.fasterxml.jackson.annotation.JsonProperty

class AdminSignRequest (
    @JsonProperty("login")
    var login: String? = null,

    @JsonProperty("password")
    var password: String? = null
)