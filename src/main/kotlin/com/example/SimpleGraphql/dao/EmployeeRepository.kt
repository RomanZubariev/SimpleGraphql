package com.example.SimpleGraphql.dao

import com.example.SimpleGraphql.dto.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<Employee, Int> {
}