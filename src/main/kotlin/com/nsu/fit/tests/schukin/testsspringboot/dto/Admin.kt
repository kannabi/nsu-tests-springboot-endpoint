package com.nsu.fit.tests.schukin.testsspringboot.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "customer")
class Admin (
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    var id: String,

    @Column(name = "login")
    var login: String,

    @Column(name = "password")
    var password: String
)