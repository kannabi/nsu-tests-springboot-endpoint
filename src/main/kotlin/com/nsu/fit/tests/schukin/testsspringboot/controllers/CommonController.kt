package com.nsu.fit.tests.schukin.testsspringboot.controllers

import com.nsu.fit.tests.schukin.testsspringboot.dto.responses.Response
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class CommonController {

    @GetMapping("/health_check")
    @ResponseBody
    fun healthCheck() = Response(HttpStatus.OK.value(), "")
}