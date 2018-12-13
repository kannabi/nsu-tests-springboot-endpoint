package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ErrorResponse (
    @field:JsonProperty("timestamp")
    var timestamp: Long? = null,

    @field:JsonProperty("status")
    var status: Int? = null,

    @field:JsonProperty("error")
    var error: String? = null,

    @field:JsonProperty("exception")
    var exception: String? = null,

    @field:JsonProperty("message")
    var message: String? = null,

    @field:JsonProperty("path")
    var path: String? = null
)