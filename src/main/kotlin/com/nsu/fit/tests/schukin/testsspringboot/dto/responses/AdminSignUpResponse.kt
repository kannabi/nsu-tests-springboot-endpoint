package com.nsu.fit.tests.schukin.testsspringboot.dto.responses

import com.nsu.fit.tests.schukin.testsspringboot.dto.Admin

data class AdminSignUpResponse (
    val token: String,
    val admin: Admin
)