package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
class Admin (

    @field:JsonProperty("id")
    var id: String? = null,

    @field:JsonProperty("login")
    var login: String? = null
)