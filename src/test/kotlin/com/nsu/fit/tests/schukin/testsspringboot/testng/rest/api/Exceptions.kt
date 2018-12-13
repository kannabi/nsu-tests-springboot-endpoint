package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api

import java.io.IOException

class ServerApiException(
    message: String,
    val code: Int
): IOException(message)