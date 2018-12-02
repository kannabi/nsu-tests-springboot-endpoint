package com.nsu.fit.tests.schukin.testsspringboot.admin.repositories

import com.nsu.fit.tests.schukin.testsspringboot.admin.dto.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository: JpaRepository<Admin, String> {
    fun findByLogin(login: String): Admin?
}