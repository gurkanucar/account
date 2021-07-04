package com.gucarsoft.account.dto

import com.gucarsoft.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDTO(
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?,
)
