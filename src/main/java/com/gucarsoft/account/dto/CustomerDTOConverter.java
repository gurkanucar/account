package com.gucarsoft.account.dto;

import com.gucarsoft.account.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOConverter {

    public AccountCustomerDTO convertToAccountCustomer(Customer from) {
        return from == null ? new AccountCustomerDTO("", "", "")
                : new AccountCustomerDTO(from.getId(), from.getName(), from.getSurname());
    }

}
