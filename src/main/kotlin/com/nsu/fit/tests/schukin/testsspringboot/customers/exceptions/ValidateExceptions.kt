package com.nsu.fit.tests.schukin.testsspringboot.customers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plan not found")
class PlanNotFound: IllegalAccessException("Plan not found")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name must be not null")
class FirstNameNull: IllegalAccessException("First name must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name length must be more than 2")
class FirstNameShort: IllegalAccessException("First name length must be more than 2")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name length must be less than 12")
class FirstNameTooLong: IllegalAccessException("First name length must be less than 12")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name length must be starts from a capital letter")
class FirstNameStartsFromCapital: IllegalAccessException("First name length must be starts from a capital letter")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name length must be not contains spaces")
class FirstNameContainsSpace: IllegalAccessException("First name length must be not contains spaces")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name must starts from a capital letter and another letters must be lowercase")
class FirstNameLowerCase: IllegalAccessException("First name must starts from a capital letter and another letters must be lowercase")



@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Last name must be not null")
class LastNameNull: IllegalAccessException("Last name must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Last name length must be more than 2")
class LastNameShort: IllegalAccessException("Last name length must be more than 2")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Last name length must be less than 12")
class LastNameTooLong: IllegalAccessException("Last name length must be less than 12")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Last name length must be starts from a capital letter")
class LastNameStartsFromCapital: IllegalAccessException("Last name length must be starts from a capital letter")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name length must be not contains spaces")
class LastNameContainsSpace: IllegalAccessException("First name length must be not contains spaces")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "First name must starts from a capital letter and another letters must be lowercase")
class LastNameLowerCase: IllegalAccessException("First name must starts from a capital letter and another letters must be lowercase")


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Login must be not null")
class LoginNull: IllegalAccessException("Login must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Login must be an email")
class LoginMustBeAnEmail: IllegalAccessException("Login must be an email")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Login must be an email")
class LoginAlreadyExists: IllegalAccessException("Login must be an email")


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Password must be not null")
class PasswordNull: IllegalAccessException("Password must be not null")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Password length must be more than 6")
class PasswordTooShort: IllegalAccessException("Password length must be more than 6")

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Password length must be less than 12")
class PasswordTooLong: IllegalAccessException("Password length must be less than 12")