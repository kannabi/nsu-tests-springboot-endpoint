package com.nsu.fit.tests.schukin.testsspringboot.common.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cannot found this login")
class LoginIncorrect : Exception()