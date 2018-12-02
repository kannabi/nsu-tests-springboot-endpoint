package com.nsu.fit.tests.schukin.testsspringboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Password is incorrect")
class PasswordIncorrect : Exception()