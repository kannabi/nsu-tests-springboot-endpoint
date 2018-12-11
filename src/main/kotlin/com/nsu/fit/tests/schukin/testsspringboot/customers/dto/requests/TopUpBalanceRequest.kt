package com.nsu.fit.tests.schukin.testsspringboot.customers.dto.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class TopUpBalanceRequest (
    @JsonProperty("incoming")
    var incoming: Int? = null
)