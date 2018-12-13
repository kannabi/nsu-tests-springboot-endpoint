package com.nsu.fit.tests.schukin.testsspringboot.plan.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan must be not null")
class PlanIsNull: IllegalAccessException("Plan must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan details must be not null")
class PlanDetailsIsNull: IllegalAccessException("Plan details must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan name must be not null")
class PlanNameIsNull: IllegalAccessException("Plan name must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan name is too short")
class PlanNameIsTooShort: IllegalAccessException("Plan name is too short")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan name is too long")
class PlanNameIsTooLong: IllegalAccessException("Plan name is too long")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan name is too incorrect")
class PlanNameIsIncorrect: IllegalAccessException("Plan name is incorrect")

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "There is a plan with this name already")
class PlanNameIsAlreadyExists: IllegalAccessException("There is a plan with this name already")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan details is too short")
class PlanDetailsIsTooShort: IllegalAccessException("Plan name is too short")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan details is too long")
class PlanDetailsIsTooLong: IllegalAccessException("Plan name is too long")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan fee is too small")
class PlanFeeIsNull: IllegalAccessException("Plan fee is too small")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan fee is too small")
class PlanFeeIsTooSmall: IllegalAccessException("Plan fee is too small")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan fee is too large")
class PlanFeeIsTooBig: IllegalAccessException("Plan fee is too large")