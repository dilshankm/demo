package com.dilshan.demo.employee;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return ResponseEntity.ok().body(employee);

    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployee().orElseThrow(EmployeeNotFoundException::new);
        return ResponseEntity.ok().body(employeeList);
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Optional<Employee> savedEmployee = employeeService.saveAndUpdateEmployee(employee);
        return savedEmployee.<ResponseEntity<Object>>map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Optional<Employee> savedEmployee = employeeService.saveAndUpdateEmployee(employee);
        return savedEmployee.<ResponseEntity<Object>>map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return  ResponseEntity.ok().build();
    }


}
