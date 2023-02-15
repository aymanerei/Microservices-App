package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.Optional;

public interface EmployeeService {

  public Optional<Employee> getEmployee(final Long id);
  public Iterable<Employee> getEmployees();
  public void deleteEmployee(final Long id);
  public Employee saveEmployee(Employee employee);

}