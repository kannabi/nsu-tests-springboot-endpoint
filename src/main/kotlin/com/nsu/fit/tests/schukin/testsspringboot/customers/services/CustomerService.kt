package com.nsu.fit.tests.schukin.testsspringboot.customers.services

import com.nsu.fit.tests.schukin.testsspringboot.common.utils.validate
import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.Customer
import com.nsu.fit.tests.schukin.testsspringboot.customers.exceptions.*
import com.nsu.fit.tests.schukin.testsspringboot.customers.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.stereotype.Service


@Service
class CustomerService
@Autowired constructor(
  private val customerRepository: CustomerRepository,
  private val encoder: BCryptPasswordEncoder
) {

    /**
     * Метод возвращает список объектов типа customer.
     */
    fun getCustomers(): List<Customer> =
        customerRepository.findAll().toList()

    /**
     * Метод создает новый объект типа Customer. Ограничения:
     * firstName - нет пробелов, длина от 2 до 12 символов включительно, начинается с заглавной буквы, остальные символы строчные, нет цифр и других символов;
     * lastName - нет пробелов, длина от 2 до 12 символов включительно, начинается с заглавной буквы, остальные символы строчные, нет цифр и других символов;
     * login - указывается в виде email, проверить email на корректность, проверить что нет customer с таким же email;
     * pass - длина от 6 до 12 символов включительно, не должен быть простым (123qwe или 1q2w3e), не должен содержать части login, firstName, lastName
     */
    fun createCustomer(firstName: String?, lastName: String?, login: String?, password: String?): Customer {
        validateCustomerFields(firstName, lastName, login, password)
        return customerRepository.save(
            Customer(
                firstName = firstName ?: throw FirstNameNull(),
                lastName = lastName ?: throw LastNameNull(),
                login = login ?: throw LoginNull(),
                pass = encoder.encode(password ?: throw PasswordNull()),
                balance = 0
            )
        )
    }

    fun getCustomer(id: String): Customer =
        customerRepository.findOne(id) ?: throw CustomerNotFound()

    /**
     * Метод обновляет объект типа Customer.
     * Можно обновить только firstName и lastName.
     */
    fun updateCustomer(id: String, firstName: String?, lastName: String?, login: String?, password: String?): Customer {
        validateCustomerFields(firstName, lastName, login, password)
        val customer = customerRepository.findOne(id) ?: throw CustomerNotFound()

        firstName?.let {
            customer.firstName = it
        }

        lastName?.let {
            customer.lastName = it
        }

        login?.let {
            customer.login = it
        }

        password?.let {
            customer.pass = encoder.encode(it)
        }

        return customerRepository.save(customer)
    }

    fun removeCustomer(id: String) =
        customerRepository.delete(id)

    /**
     * Метод добавляет к текущему баласу amount.
     * amount - должен быть строго больше нуля.
     */
    fun topUpBalance(customerId: String, amount: Int): Customer {
        if (amount <= 0) {
            throw BalanceIncomingException()
        }
        val customer = customerRepository.findOne(customerId) ?: throw CustomerNotFound()
        customer.balance += amount
        return customerRepository.save(customer)
    }

    private fun validateCustomerFields(firstName: String?, lastName: String?, login: String?, password: String?) {

        firstName?.let {
            validate(it.length > 2, FirstNameShort::class.java)
            validate(it.length < 12, FirstNameTooLong::class.java)
            validate(it[0].isUpperCase(), FirstNameStartsFromCapital::class.java)
            validate(!it.contains(' '), FirstNameContainsSpace::class.java)
            validate(it.matches(Regex("^[A-Z][a-z]*")), FirstNameLowerCase::class.java)
        }

        lastName?.let {
            validate(it.length > 2, LastNameShort::class.java)
            validate(it.length < 12, LastNameTooLong::class.java)
            validate(it[0].isUpperCase(), LastNameStartsFromCapital::class.java)
            validate(!it.contains(' '), LastNameContainsSpace::class.java)
            validate(it.matches(Regex("^[A-Z][a-z]*")), LastNameLowerCase::class.java)
        }

        login?.let {
            validate(
                it.matches(Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+$")),
                LoginMustBeAnEmail::class.java
            )
            validate(customerRepository.findByLogin(it) == null, LoginAlreadyExists::class.java)
        }

        password?.let {
            validate(it.length > 6, PasswordTooShort::class.java)
            validate(it.length < 12, PasswordTooLong::class.java)
        }
    }
}
