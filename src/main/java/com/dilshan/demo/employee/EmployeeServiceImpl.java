package com.dilshan.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public Optional<List<Employee>> getAllEmployee() {
        return Optional.of(employeeRepository.findAll());
    }

    public Optional<Employee> saveAndUpdateEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    public void deleteEmployee(Integer employeeId) {
         employeeRepository.deleteById(employeeId);
    }

}
