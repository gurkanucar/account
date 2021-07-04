package com.gucarsoft.account.repository;

import com.gucarsoft.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
