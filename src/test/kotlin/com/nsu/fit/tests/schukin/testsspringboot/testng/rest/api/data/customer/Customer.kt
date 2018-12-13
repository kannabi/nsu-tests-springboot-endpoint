package com.nsu.fit.tests.schukin.testsspringboot.testng.rest.api.data.customer

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @field:JsonProperty("id")
    var id: String? = null,

    @Column(name = "first_name")
    @field:JsonProperty("firstName")
    var firstName: String,

    @Column(name = "last_name")
    @field:JsonProperty("lastName")
    var lastName: String,

    @Column(name = "login")
    @field:JsonProperty("login")
    var login: String,

    @Column(name = "pass")
    @JsonIgnore
    var pass: String,

    @Column(name = "balance")
    @field:JsonProperty("balance")
    var balance: Int = 0
)
