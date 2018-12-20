package com.nsu.fit.tests.schukin.testsspringboot.subscription.dto.requests

import com.fasterxml.jackson.annotation.JsonProperty

class CreateSubscriptionRequest (

    @field:JsonProperty("customerId")
    var customerId: String? = null,

    @field:JsonProperty("planId")
    var planId: String? = null

)