package com.nsu.fit.tests.schukin.testsspringboot.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "plan")
class Plan(

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @JsonProperty("id")
    var id: String,

    @JsonProperty("name")
    @Column(name = "name")
    var name: String,

    @JsonProperty("details")
    @Column(name = "details")
    var details: String,

    @Column(name = "fee")
    @JsonProperty("fee")
    var fee: Int
)
