package com.gucarsoft.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDTO(
    val id: String?,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDTO?,
    val transactions: Set<TransactionDTO>?
)
