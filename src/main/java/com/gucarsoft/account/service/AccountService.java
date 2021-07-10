package com.gucarsoft.account.service;

import com.gucarsoft.account.dto.AccountDTO;
import com.gucarsoft.account.dto.AccountDTOConverter;
import com.gucarsoft.account.dto.CreateAccountRequest;
import com.gucarsoft.account.model.Account;
import com.gucarsoft.account.model.Customer;
import com.gucarsoft.account.model.Transaction;
import com.gucarsoft.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDTOConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDTOConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction=new Transaction(createAccountRequest.getInitialCredit(),account);
            account.getTransaction().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }

}
