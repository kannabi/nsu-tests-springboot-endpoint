package com.nsu.fit.tests.schukin.testsspringboot.plan.repositories

import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import org.springframework.data.repository.CrudRepository

interface PlanRepository: CrudRepository<Plan, String>