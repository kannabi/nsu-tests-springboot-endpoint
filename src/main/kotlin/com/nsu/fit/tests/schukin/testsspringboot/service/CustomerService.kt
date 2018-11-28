package com.nsu.fit.tests.schukin.testsspringboot.service

import com.nsu.fit.tests.schukin.testsspringboot.dto.Customer
import org.apache.commons.lang3.Validate

import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomerService {

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
    fun createCustomer(customer: Customer): Customer {
        Validate.notNull(customer, "Argument 'customerData' is null.")

        Validate.notNull(customer.pass)
        Validate.isTrue(customer.pass.length in 6..12, "Password's length should be more or equal 6 symbols and less or equal 12 symbols.")
//        Validate.isTrue(!customer.pass.equalsIgnoreCase("123qwe"), "Password is easy.")

        // TODO: необходимо дописать дополнительные проверки

//        return dbService.createCustomer(customer)
        return TODO()
    }


    /**
     * Метод обновляет объект типа Customer.
     * Можно обновить только firstName и lastName.
     */
    fun updateCustomer(customer: Customer): Customer {
        throw NotImplementedError("Please implement the method.")
    }

    fun removeCustomer(id: UUID) {
        throw NotImplementedError("Please implement the method.")
    }

    /**
     * Метод добавляет к текущему баласу amount.
     * amount - должен быть строго больше нуля.
     */
    fun topUpBalance(customerId: UUID, amount: Int): Customer {
        throw NotImplementedError("Please implement the method.")
    }
}
