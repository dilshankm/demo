package com.dilshan.demo.employee;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Employee not found. " + id);
    }

    public EmployeeNotFoundException() {
        super("Error in get all employee ");
    }

}
