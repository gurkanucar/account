package com.gucarsoft.account.dto;

import com.gucarsoft.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDTOConverter {

    private final CustomerAccountDTOConverter customerAccountDTOConverter;

    public CustomerDTOConverter(CustomerAccountDTOConverter converter) {
        this.customerAccountDTOConverter = converter;
    }

    public AccountCustomerDTO convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDTO(f.getId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDTO convertToCustomerDTO(Customer from) {
        return new CustomerDTO(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts()
                        .stream()
                        .map(customerAccountDTOConverter::convert)
                        .collect(Collectors.toSet()));

    }


}
