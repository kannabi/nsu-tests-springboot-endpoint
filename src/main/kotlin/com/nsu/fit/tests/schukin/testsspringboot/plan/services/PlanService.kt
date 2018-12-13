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
    fun createPlan(plan: Plan): Plan {
        validatePlan(plan)
//        return dbService.createPlan(plan)
        return TODO()
    }

    fun updatePlan(plan: Plan): Plan {
        TODO()
    }

    fun removePlan(id: UUID) {
        TODO()
    }

    /**
     * Метод возвращает список планов доступных для покупки.
     */
    fun getPlans(customerId: UUID): List<Plan> {
        TODO()
    }

    private fun validatePlan(plan: Plan) {
        plan.let { it ->

            (it.name ?: throw PlanNameIsNull()).apply {
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

            (it.details ?: throw PlanDetailsIsNull()).length.let { detailsLen ->
                validate(detailsLen >= 1, PlanDetailsIsTooShort::class.java)
                validate(detailsLen <= 1024, PlanDetailsIsTooLong::class.java)
            }

            (it.fee ?: throw PlanFeeIsNull()).let { fee ->
                validate(fee >= 0, PlanFeeIsTooSmall::class.java)
                validate(fee <= 999999, PlanFeeIsTooBig::class.java)
            }
        }
    }
}
