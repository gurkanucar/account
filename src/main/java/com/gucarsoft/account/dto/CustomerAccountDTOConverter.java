package com.gucarsoft.account.dto;

import com.gucarsoft.account.model.Account;
import com.gucarsoft.account.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDTOConverter {

    private final TransactionDTOConverter converter;

    public CustomerAccountDTOConverter(TransactionDTOConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDTO convert(Account from) {
        return new CustomerAccountDTO(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()),
                from.getCreationDate()
        );
    }

}
