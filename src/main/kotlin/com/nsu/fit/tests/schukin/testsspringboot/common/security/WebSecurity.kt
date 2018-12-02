package com.nsu.fit.tests.schukin.testsspringboot.common.security

import com.nsu.fit.tests.schukin.testsspringboot.common.security.SecurityUtils.ADMIN_CREATE_URL
import com.nsu.fit.tests.schukin.testsspringboot.common.security.SecurityUtils.ADMIN_LOGIN_URL
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

import com.nsu.fit.tests.schukin.testsspringboot.common.security.SecurityUtils.HEALTH_CHECK

@Configuration
@EnableWebSecurity
class WebSecurity : WebSecurityConfigurerAdapter() {

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder =
        BCryptPasswordEncoder()

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable().authorizeRequests()
            .antMatchers(
                HttpMethod.POST,
                HEALTH_CHECK, ADMIN_CREATE_URL, ADMIN_LOGIN_URL
            ).permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(JWTAuthenticationFilter(authenticationManager()))
            .addFilter(JWTAuthorizationFilter(authenticationManager()))
    }

    @Throws(Exception::class)
    public override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", CorsConfiguration().applyPermitDefaultValues())
        return source
    }
}
