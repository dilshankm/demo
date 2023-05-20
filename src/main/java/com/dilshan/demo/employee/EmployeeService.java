package com.dilshan.demo.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<Employee> getEmployeeById(int id);

    public Optional<List<Employee>> getAllEmployee();

    public Optional<Employee> saveAndUpdateEmployee(Employee employee);
    public void deleteEmployee(Integer employeeId);

}
