package com.gucarsoft.account;

import com.gucarsoft.account.model.Customer;
import com.gucarsoft.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		/*Account a= new Account("a", BigDecimal.ONE, LocalDateTime.now(),null, SetsKt.emptySet());
		Account b= new Account("a", BigDecimal.ONE, LocalDateTime.now(),null, SetsKt.emptySet());*/
       Customer customer = customerRepository.save(new Customer("", "mehmet", "ahmet", new HashSet<>()));
        System.out.println(customer.getId());
    }
}
