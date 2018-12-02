package com.nsu.fit.tests.schukin.testsspringboot.common.utils

import java.lang.Exception


fun <T: Throwable> validate(check: Boolean, exception: Class<T>) {
    if (!check) {
        throw exception.newInstance()
    }
}