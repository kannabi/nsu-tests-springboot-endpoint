package com.nsu.fit.tests.schukin.testsspringboot.plan.dto.requests

import com.fasterxml.jackson.annotation.JsonProperty

class CreatePlanRequest (

    @field:JsonProperty("name")
    var name: String? = null,

    @field:JsonProperty("details")
    var details: String? = null,

    @field:JsonProperty("fee")
    var fee: Int? = null
)