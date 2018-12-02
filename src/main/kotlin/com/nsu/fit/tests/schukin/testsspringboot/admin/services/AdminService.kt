package com.nsu.fit.tests.schukin.testsspringboot.admin.services

import com.nsu.fit.tests.schukin.testsspringboot.customers.services.CustomerService
import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.Admin
import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.responses.AdminSignInResponse
import com.nsu.fit.tests.schukin.testsspringboot.common.exceptions.LoginIncorrect
import com.nsu.fit.tests.schukin.testsspringboot.common.exceptions.PasswordIncorrect
import com.nsu.fit.tests.schukin.testsspringboot.admin.repositories.AdminRepository
import com.nsu.fit.tests.schukin.testsspringboot.common.security.SecurityUtils
import com.nsu.fit.tests.schukin.testsspringboot.plan.services.PlanService
import com.nsu.fit.tests.schukin.testsspringboot.subscription.services.SubscriptionService
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