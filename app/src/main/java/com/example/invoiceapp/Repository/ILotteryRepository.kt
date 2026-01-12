package com.example.invoiceapp.Repository

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result

interface ILotteryRepository {
    suspend fun getLotteryNumber(): Result<InvoiceNumber>
}
