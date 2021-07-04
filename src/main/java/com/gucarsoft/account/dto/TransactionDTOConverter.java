package com.gucarsoft.account.dto;

import com.gucarsoft.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDTOConverter {

    public TransactionDTO convert(Transaction from){
        return new TransactionDTO(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }

}
