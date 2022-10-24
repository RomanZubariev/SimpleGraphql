package com.example.SimpleGraphql.controller

import com.example.SimpleGraphql.dto.Employee
import com.example.SimpleGraphql.dto.EmployeeInput
import com.example.SimpleGraphql.service.EmployeeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class EmployeeController @Autowired constructor(var employeeService: EmployeeService) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @QueryMapping
    fun employeeById(@Argument id: Int): Employee {
        log.info("EmployeeById id=$id")
        return employeeService.getById(id)
    }

    @QueryMapping
    fun allEmployees(): List<Employee> {
        log.info("AllEmployees")
        return employeeService.getAll()
    }

    @MutationMapping
    fun updateEmployee(@Argument employee: EmployeeInput): Employee {
        return employeeService.update(employee.toEntity())
    }

    @MutationMapping
    fun createEmployee(@Argument employee: EmployeeInput): Employee {
        return employeeService.save(employee.toEntity())
    }

    @MutationMapping
    fun deleteEmployee(@Argument id: Int): String {
        employeeService.deleteById(id)
        return "Employee #$id was deleted"
    }
}