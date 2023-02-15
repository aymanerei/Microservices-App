package com.example.employeeservice.service.impl;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Optional<Employee> getEmployee(final Long id){

    return employeeRepository.findById(id);

  }

  @Override
  public Iterable<Employee> getEmployees() {

    return employeeRepository.findAll();

  }

  @Override
  public void deleteEmployee(final Long id) {

    employeeRepository.deleteById(id);

  }

  @Override
  public Employee saveEmployee(Employee employee) {

    Employee savedEmployee = employeeRepository.save(employee);

    return savedEmployee;

  }
}
