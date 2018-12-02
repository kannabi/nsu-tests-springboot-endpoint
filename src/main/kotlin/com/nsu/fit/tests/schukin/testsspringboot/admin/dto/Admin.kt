package com.nsu.fit.tests.schukin.testsspringboot.admin.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "admin")
@JsonInclude(JsonInclude.Include.NON_NULL)
class Admin (
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @JsonProperty
    var id: String? = null,

    @Column(name = "login")
    @JsonProperty("login")
    var login: String,

    @Column(name = "password")
    @JsonIgnore
    var password: String
)