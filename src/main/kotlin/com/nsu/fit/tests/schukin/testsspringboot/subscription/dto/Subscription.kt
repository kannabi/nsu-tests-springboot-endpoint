package com.nsu.fit.tests.schukin.testsspringboot.subscription.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.nsu.fit.tests.schukin.testsspringboot.customers.dto.Customer
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.Plan
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "subscription")
class Subscription (

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @field:JsonProperty("id")
    var id: String? = null,

    @OneToOne
    @JoinColumn(name = "customer_id")
    @field:JsonProperty("customerId")
    var customer: Customer? = null,

    @OneToOne
    @JoinColumn(name = "plan_id")
    @field:JsonProperty("planId")
    var plan: Plan? = null
)
