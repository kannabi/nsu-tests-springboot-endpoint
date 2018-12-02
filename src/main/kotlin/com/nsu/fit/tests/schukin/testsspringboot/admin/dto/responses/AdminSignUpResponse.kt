package com.nsu.fit.tests.schukin.testsspringboot.admin.dto.responses

import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.Admin

data class AdminSignUpResponse (
    val token: String,
    val admin: Admin
)