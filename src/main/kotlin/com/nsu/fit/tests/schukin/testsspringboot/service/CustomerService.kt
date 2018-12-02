package com.nsu.fit.tests.schukin.testsspringboot.service

import com.nsu.fit.tests.schukin.testsspringboot.dto.Customer
import com.nsu.fit.tests.schukin.testsspringboot.repositories.CustomerRepository
import org.apache.commons.lang3.Validate
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomerService
@Autowired constructor(
  customerRepository: CustomerRepository
) {

    /**
     * Метод возвращает список объектов типа customer.
     */
    fun getCustomers(): List<Customer> = listOf()

    /**
     * Метод создает новый объект типа Customer. Ограничения:
     * Аргумент 'customerData' - не null;
     * firstName - нет пробелов, длина от 2 до 12 символов включительно, начинается с заглавной буквы, остальные символы строчные, нет цифр и других символов;
     * lastName - нет пробелов, длина от 2 до 12 символов включительно, начинается с заглавной буквы, остальные символы строчные, нет цифр и других символов;
     * login - указывается в виде email, проверить email на корректность, проверить что нет customer с таким же email;
     * pass - длина от 6 до 12 символов включительно, не должен быть простым (123qwe или 1q2w3e), не должен содержать части login, firstName, lastName
     * money - должно быть равно 0.
     */
    fun createCustomer(firstName: String?, lastName: String?, login: String?, password: String?): Customer {
//        Validate.notNull(customer, "Argument 'customerData' is null.")
//
//        Validate.notNull(customer.pass)
//        Validate.isTrue(customer.pass.length in 6..12, "Password's length should be more or equal 6 symbols and less or equal 12 symbols.")
////        Validate.isTrue(!customer.pass.equalsIgnoreCase("123qwe"), "Password is easy.")
//
//        // TODO: необходимо дописать дополнительные проверки
//
////        return dbService.createCustomer(customer)
        return TODO()
    }

    fun getCustomer(id: String): Customer {
        TODO()
    }

    /**
     * Метод обновляет объект типа Customer.
     * Можно обновить только firstName и lastName.
     */
    fun updateCustomer(firstName: String?, lastName: String?, login: String?, password: String?): Customer {
        throw NotImplementedError("Please implement the method.")
    }

    fun removeCustomer(id: String) {
        throw NotImplementedError("Please implement the method.")
    }

    /**
     * Метод добавляет к текущему баласу amount.
     * amount - должен быть строго больше нуля.
     */
    fun topUpBalance(customerId: UUID, amount: Int): Customer {
        throw NotImplementedError("Please implement the method.")
    }

    private fun checkCustomerFields(firstName: String?, lastName: String?, login: String?, password: String?) {

    }
}
