package com.nsu.fit.tests.schukin.testsspringboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Login or password cannot be null")
class InvalidAdminSignRequest: Exception()