package com.gucarsoft.account.service;

import com.gucarsoft.account.dto.CustomerDTOConverter;
import com.gucarsoft.account.model.Customer;
import com.gucarsoft.account.repository.CustomerRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private CustomerDTOConverter converter;

    private CustomerService service;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDTOConverter.class);
        service = new CustomerService(customerRepository, converter);
    }


    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id", "name", "surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Customer result = service.findCustomerById("id");
        Assertions.assertEquals(result,
                customer);
    }




}