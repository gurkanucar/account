package com.gucarsoft.account.dto


data class CustomerDTO(
    val id: String?,
    val name: String?,
    val surname: String?,
    val accounts: Set<CustomerAccountDTO>,
)
