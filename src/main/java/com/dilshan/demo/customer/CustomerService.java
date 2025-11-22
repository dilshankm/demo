package com.dilshan.demo.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public Optional<Customer> updateById(String id, Customer customer) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        Customer updatedCustomer = new Customer(
                id,
                customer.name(),
                customer.email()
        );
        return Optional.of(customerRepository.save(updatedCustomer));
    }



    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    public Optional<Boolean> existsCustomerById(String id) {
        return customerRepository.existsCustomerById(id);
    }
}
