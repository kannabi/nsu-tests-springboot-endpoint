package com.nsu.fit.tests.schukin.testsspringboot.plan.controllers

import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.requests.CreatePlanRequest
import com.nsu.fit.tests.schukin.testsspringboot.plan.dto.requests.UpdatePlanRequest
import com.nsu.fit.tests.schukin.testsspringboot.plan.services.PlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/plan")
class PlanController
@Autowired constructor(
    private val planService: PlanService
) {

    @PostMapping()
    @ResponseBody
    fun createPlan(@RequestBody createPlanRequest: CreatePlanRequest) =
        ResponseEntity(
            planService.createPlan(
                createPlanRequest.name,
                createPlanRequest.details,
                createPlanRequest.fee
            ),
            HttpStatus.CREATED
        )


    @PutMapping("/{id}")
    @ResponseBody
    fun updatePlan(
        @PathVariable("id") id: String,
        @RequestBody updatePlanRequest: UpdatePlanRequest
    ) =
        ResponseEntity(
            planService.updatePlan(
                id,
                updatePlanRequest.name,
                updatePlanRequest.details,
                updatePlanRequest.fee
            ),
            HttpStatus.OK
        )

    @GetMapping("/{id}")
    @ResponseBody
    fun getPlan(
        @PathVariable("id") id: String
    ) =
        ResponseEntity(
            planService.getPlan(id),
            HttpStatus.OK
        )

    @GetMapping("/all")
    @ResponseBody
    fun getAllPlans() =
        ResponseEntity(
            planService.getPlans(),
            HttpStatus.OK
        )

    @DeleteMapping("/{id}")
    fun deletePlan(@PathVariable("id") id: String) =
        ResponseEntity(
            planService.removePlan(id),
            HttpStatus.OK
        )
}