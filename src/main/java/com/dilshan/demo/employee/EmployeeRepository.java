package com.dilshan.demo.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    Optional<Employee> getEmployeeById(int id);
}
