package com.nsu.fit.tests.schukin.testsspringboot.repositories

import com.nsu.fit.tests.schukin.testsspringboot.dto.Plan
import org.springframework.data.repository.CrudRepository

interface PlanRepository: CrudRepository<Plan, String>