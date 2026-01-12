package com.example.invoiceapp.Utils

class ApiException(
    message: String = "",
    val code: Int,
    val result: Int = -1,
) : RuntimeException(message)
