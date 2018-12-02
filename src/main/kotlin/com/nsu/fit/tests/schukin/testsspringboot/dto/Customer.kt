package com.nsu.fit.tests.schukin.testsspringboot.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "customer")
data class Customer (

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @JsonProperty("id")
    var id: String? = null,

    @Column(name = "first_name")
    @JsonProperty("firstName")
    var firstName: String,

    @Column(name = "last_name")
    @JsonProperty("lastName")
    var lastName: String,

    @Column(name = "login")
    @JsonProperty("login")
    var login: String,

    @Column(name = "pass")
    @JsonProperty("pass")
    var pass: String,

    @Column(name = "balance")
    @JsonProperty("balance")
    var balance: Int = 0
)
