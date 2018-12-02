package com.nsu.fit.tests.schukin.testsspringboot.dto.responses

import com.nsu.fit.tests.schukin.testsspringboot.dto.Admin

class AdminSignInResponse (
    val token: String,
    val admin: Admin
)