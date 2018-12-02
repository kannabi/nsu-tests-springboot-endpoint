package com.nsu.fit.tests.schukin.testsspringboot.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

import java.util.Date

object SecurityUtils {
    const val SECRET = "SecretKeyToGenJWTs"
    const val EXPIRATION_TIME: Long = 864000000 // 10 days
    const val TOKEN_PREFIX = "Bearer "
    const val HEADER_STRING = "Authorization"
    const val HEALTH_CHECK = "/health_check"
    const val ADMIN_CREATE_URL = "/admin/sign-up"
    const val ADMIN_LOGIN_URL = "/admin/sign-in"
    const val ADMIN_CREATE_SECRET = "aaaaaaaaaaaa"

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET.toByteArray())
            .compact()
    }
}
