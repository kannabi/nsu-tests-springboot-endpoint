package com.nsu.fit.tests.schukin.testsspringboot.plan.services

import com.nsu.fit.tests.schukin.testsspringboot.common.utils.validate
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import com.nsu.fit.tests.schukin.testsspringboot.plan.exceptions.*
import com.nsu.fit.tests.schukin.testsspringboot.plan.repositories.PlanRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern


@Service
class PlanService
@Autowired constructor(
    private val planRepository: PlanRepository
) {
    /**
     * Метод создает новый объект типа Plan. Ограничения:
     * name - длина не больше 128 символов и не меньше 2 включительно не содержит спец символов. Имена не пересекаются друг с другом;
     * details - длина не больше 1024 символов и не меньше 1 включительно;
     * fee - больше либо равно 0 но меньше либо равно 999999.
     */
    fun createPlan(name: String?, details: String?, fee: Int?): Plan {
        validatePlan(
            name ?: throw PlanNameIsNull(),
            details ?: throw PlanDetailsIsNull(),
            fee ?: throw PlanFeeIsNull()
        )
        return planRepository.save(
            Plan(
                name = name,
                details = details,
                fee = fee
            )
        )
    }

    fun updatePlan(id: String, name: String?, details: String?, fee: Int?): Plan {
        validatePlan(name, details, fee)
        val plan = planRepository.findOne(id)

        name?.let {
            plan.name = name
        }

        details?.let {
            plan.details = details
        }

        fee?.let {
            plan.fee = null
        }

        return planRepository.save(plan)
    }

    fun removePlan(id: String) =
        planRepository.delete(id)

    fun getPlan(id: String): Plan? =
        planRepository.findOne(id)

    /**
     * Метод возвращает список планов доступных для покупки.
     */
    fun getPlans(): List<Plan> =
        planRepository.findAll().toList()

    private fun validatePlan(name: String?, details: String?, fee: Int?) {

        name?.apply {
            validate(length >= 2, PlanNameIsTooShort::class.java)
            validate(length <= 128, PlanNameIsTooLong::class.java)
            validate(
                Pattern.matches("[a-zA-Z0-9_\\-\\s]*", this),
                PlanNameIsIncorrect::class.java
            )

            validate(
                planRepository.findByName(this) == null,
                PlanNameIsAlreadyExists::class.java
            )
        }

        details?.length?.let { detailsLen ->
            validate(detailsLen >= 1, PlanDetailsIsTooShort::class.java)
            validate(detailsLen <= 1024, PlanDetailsIsTooLong::class.java)
        }

        fee?.let {
            validate(it >= 0, PlanFeeIsTooSmall::class.java)
            validate(it <= 999999, PlanFeeIsTooBig::class.java)
        }
    }
}
