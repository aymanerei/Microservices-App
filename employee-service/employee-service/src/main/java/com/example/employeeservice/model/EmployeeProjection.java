package com.example.employeeservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullEmployee",types = Employee.class)
public interface EmployeeProjection {
  public Long getId();
  public String getFirstName();
  public String getLastName();
}