package com.example.SimpleGraphql.dto

import java.time.LocalDate

data class EmployeeInput(
    var employeeId: Int?,
    var firstName: String?,
    var lastName: String?,
    var departmentId: Int?,
    var jobTitle: String?,
    var gender: Gender?,
    var dateOfBirth: String?
) {
    constructor() : this(null, null, null, null, null, null, null)

    fun toEntity(): Employee = Employee(
        employeeId,
        firstName,
        lastName,
        departmentId,
        jobTitle,
        gender,
        LocalDate.parse(dateOfBirth)
    )
}