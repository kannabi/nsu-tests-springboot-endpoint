package com.nsu.fit.tests.schukin.testsspringboot.admin.dto.responses

import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.Admin

class AdminSignInResponse (
    val token: String,
    val admin: Admin
)