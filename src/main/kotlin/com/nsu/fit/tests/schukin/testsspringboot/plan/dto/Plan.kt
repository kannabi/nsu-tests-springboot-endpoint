package com.nsu.fit.tests.schukin.testsspringboot.plan.dto

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
    @field:JsonProperty("id")
    var id: String? = null,

    @field:JsonProperty("name")
    @Column(name = "name")
    var name: String? = null,

    @field:JsonProperty("details")
    @Column(name = "details")
    var details: String? = null,

    @Column(name = "fee")
    @field:JsonProperty("fee")
    var fee: Int? = null
)
