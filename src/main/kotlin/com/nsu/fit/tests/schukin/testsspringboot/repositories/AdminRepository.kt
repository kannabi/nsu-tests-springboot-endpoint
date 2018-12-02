package com.nsu.fit.tests.schukin.testsspringboot.repositories

import com.nsu.fit.tests.schukin.testsspringboot.dto.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository: JpaRepository<Admin, String> {
    fun findByLogin(login: String): Admin?
}