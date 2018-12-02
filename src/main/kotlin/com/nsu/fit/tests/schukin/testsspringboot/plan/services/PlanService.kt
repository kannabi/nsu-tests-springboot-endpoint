package com.nsu.fit.tests.schukin.testsspringboot.plan.services

import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan

import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern


@Service
class PlanService {
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
//        Validate.notNull(plan, "Plan must be not null")
//        plan.let { it ->
//            Validate.notNull(it.details, "Plan details must be not null")
//            Validate.notNull(it.name, "Plan name must be not null")
//
//            it.name.apply {
//                Validate.isTrue(length >= 2, "Name is too short")
//                Validate.isTrue(length <= 128, "Name is too long")
//                Validate.isTrue(
//                    Pattern.matches("[a-zA-Z0-9_\\-\\s]*", this),
//                    "Name contains incorrect characters"
//                )
////                Validate.isTrue(
////                    !dbService.hasPlanWithName(this),
////                    "There is plan with a this name already"
////                )
//            }
//
//            it.details.length.let { detailsLen ->
//                Validate.isTrue(detailsLen >= 1, "Details is too short")
//                Validate.isTrue(detailsLen <= 1024, "Details is too long")
//            }
//
//            it.fee.let { fee ->
//                Validate.isTrue(fee >= 0, "Fee cannot be negative")
//                Validate.isTrue(fee <= 999999, "Fee is too large")
//            }
//        }
    }
}
