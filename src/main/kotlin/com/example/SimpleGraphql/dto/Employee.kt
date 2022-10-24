package com.example.SimpleGraphql.dto

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var employeeId: Int?,
    var firstName: String?,
    var lastName: String?,
    var departmentId: Int?,
    var jobTitle: String?,
    @Enumerated(EnumType.STRING)
    var gender: Gender?,
    var dateOfBirth: LocalDate?
) {
    constructor() : this(null, null, null, null, null, null, null)
}