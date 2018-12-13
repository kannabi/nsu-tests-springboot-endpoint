package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.admin

import com.fasterxml.jackson.annotation.JsonProperty
import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.Admin

class AdminSignInResponse (
    @field:JsonProperty("token")
    val token: String? = null,

    @field:JsonProperty("admin")
    val admin: Admin? = null
)