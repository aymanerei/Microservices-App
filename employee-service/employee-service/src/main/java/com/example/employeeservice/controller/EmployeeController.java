package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees/api")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;


  /**
   * Create - Add a new employee
   * @param employee An object employee
   * @return The employee object saved
   */
  @RolesAllowed({"USER","ADMIN"})
  @PostMapping("/employee")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
  }


  /**
   * Read - Get one employee
   * @param id The id of the employee
   * @return An Employee object full filled
   */
  @RolesAllowed("USER")
  @GetMapping("/employee/{id}")
  public Employee getEmployee(@PathVariable("id") final Long id) {
    Optional<Employee> employee = employeeService.getEmployee(id);
    if(employee.isPresent()) {
      return employee.get();
    } else {
      return null;
    }
  }

  /**
   * Read - Get all employees
   * @return - An Iterable object of Employee full filled
   */
  @RolesAllowed("USER")
  @GetMapping("/employees")
  public Iterable<Employee> getEmployees() {
    return employeeService.getEmployees();
  }

  /**
   * Update - Update an existing employee
   * @param id - The id of the employee to update
   * @param employee - The employee object updated
   * @return
   */
  @RolesAllowed({"USER","ADMIN"})
  @PutMapping("/employee/{id}")
  public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
    Optional<Employee> e = employeeService.getEmployee(id);
    if(e.isPresent()) {
      Employee currentEmployee = e.get();

      String firstName = employee.getFirstName();
      if(firstName != null) {
        currentEmployee.setFirstName(firstName);
      }
      String lastName = employee.getLastName();
      if(lastName != null) {
        currentEmployee.setLastName(lastName);;
      }
      employeeService.saveEmployee(currentEmployee);
      return currentEmployee;
    } else {
      return null;
    }
  }


  /**
   * Delete - Delete an employee
   * @param id - The id of the employee to delete
   */
  @RolesAllowed({"USER","ADMIN"})
  @DeleteMapping("/employee/{id}")
  public void deleteEmployee(@PathVariable("id") final Long id) {
    employeeService.deleteEmployee(id);
  }

  @RolesAllowed("USER")
  @GetMapping("/logout")
  public void logout(HttpServletRequest request) throws ServletException {
    request.logout();
  }
}
