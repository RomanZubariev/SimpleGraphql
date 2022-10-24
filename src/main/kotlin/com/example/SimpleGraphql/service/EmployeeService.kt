package com.example.SimpleGraphql.service

import com.example.SimpleGraphql.dto.Employee

interface EmployeeService {
    fun getById(id: Int): Employee
    fun getAll(): List<Employee>
    fun save(employee: Employee): Employee
    fun update(employee: Employee): Employee
    fun deleteById(id: Int)
}