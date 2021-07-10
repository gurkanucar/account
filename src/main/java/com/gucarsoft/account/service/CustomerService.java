package com.gucarsoft.account.service;

import com.gucarsoft.account.dto.CustomerDTO;
import com.gucarsoft.account.dto.CustomerDTOConverter;
import com.gucarsoft.account.exception.CustomerNotFoundException;
import com.gucarsoft.account.model.Customer;
import com.gucarsoft.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDTOConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));

    }
    public CustomerDTO getCustomerById(String customerID) {
        return converter.convertToCustomerDTO(findCustomerById(customerID));
    }
}
