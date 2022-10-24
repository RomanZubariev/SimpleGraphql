package com.example.SimpleGraphql.service

import com.example.SimpleGraphql.dao.EmployeeRepository
import com.example.SimpleGraphql.dto.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.util.Streamable
import org.springframework.stereotype.Service


@Service
class EmployeeServiceImpl @Autowired constructor(var employeeRepository: EmployeeRepository) :
    EmployeeService {

    override fun getById(id: Int): Employee {
        return employeeRepository.findByIdOrNull(id)
            ?: throw EmptyResultDataAccessException("Cannot find employee with id = $id", 1)
    }

    override fun getAll(): List<Employee> {
        return Streamable.of(employeeRepository.findAll()).toList()
    }

    override fun save(employee: Employee): Employee {
        require(employee.employeeId == null)
        return employeeRepository.save(employee)
    }

    override fun update(employee: Employee): Employee {
        check(employeeRepository.existsById(employee.employeeId!!))
        return employeeRepository.save(employee)
    }

    override fun deleteById(id: Int) {
        employeeRepository.deleteById(id)
    }
}