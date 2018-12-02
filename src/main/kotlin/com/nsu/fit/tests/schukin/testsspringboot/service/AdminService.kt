package com.nsu.fit.tests.schukin.testsspringboot.service

import com.nsu.fit.tests.schukin.testsspringboot.dto.Admin
import com.nsu.fit.tests.schukin.testsspringboot.dto.responses.AdminSignInResponse
import com.nsu.fit.tests.schukin.testsspringboot.exceptions.LoginIncorrect
import com.nsu.fit.tests.schukin.testsspringboot.exceptions.PasswordIncorrect
import com.nsu.fit.tests.schukin.testsspringboot.repositories.AdminRepository
import com.nsu.fit.tests.schukin.testsspringboot.security.SecurityUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class AdminService
@Autowired constructor(
    private val customerService: CustomerService,
    private val planService: PlanService,
    private val subscriptionService: SubscriptionService,
    private val adminRepository: AdminRepository,
    private val encoder: BCryptPasswordEncoder
) {

    fun createAdmin(login: String, password: String): Admin {
        return adminRepository.save(
            Admin(
                login = login,
                password = encoder.encode(password)
//                password = password
            )
        )
    }

    fun loginAdmin(login: String, password: String): AdminSignInResponse {
        val admin = adminRepository.findByLogin(login) ?: throw LoginIncorrect()

        if (encoder.matches(password, admin.password)) {
            return AdminSignInResponse(
                SecurityUtils.generateToken(admin.login),
                admin
            )
        } else {
            throw PasswordIncorrect()
        }
    }
}