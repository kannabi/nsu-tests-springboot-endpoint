package com.nsu.fit.tests.schukin.testsspringboot.controllers

import com.nsu.fit.tests.schukin.testsspringboot.dto.requests.AdminSignRequest
import com.nsu.fit.tests.schukin.testsspringboot.dto.responses.AdminSignInResponse
import com.nsu.fit.tests.schukin.testsspringboot.dto.responses.AdminSignUpResponse
import com.nsu.fit.tests.schukin.testsspringboot.exceptions.InvalidAdminSignRequest
import com.nsu.fit.tests.schukin.testsspringboot.security.SecurityUtils
import com.nsu.fit.tests.schukin.testsspringboot.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class AdminController
@Autowired constructor(
    private val adminService: AdminService
) {

    @PostMapping("/sign-up")
    @ResponseBody
    fun signUp(@RequestBody signRequest: AdminSignRequest): ResponseEntity<AdminSignUpResponse> {
        if (signRequest.login == null || signRequest.password == null) {
            throw InvalidAdminSignRequest()
        }
        val admin = adminService.createAdmin(signRequest.login!!, signRequest.password!!)
        return ResponseEntity(
            AdminSignUpResponse(
                SecurityUtils.generateToken(admin.login), admin
            ),
            HttpStatus.OK
        )
    }

    @PostMapping("/sign-in")
    @ResponseBody
    fun signIn(@RequestBody signRequest: AdminSignRequest): ResponseEntity<AdminSignInResponse> {
        return ResponseEntity(
            adminService.loginAdmin(
                signRequest.login ?: throw InvalidAdminSignRequest(),
                signRequest.password ?: throw InvalidAdminSignRequest()
            ),
            HttpStatus.OK
        )
    }
}