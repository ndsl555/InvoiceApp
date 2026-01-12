package com.example.invoiceapp.DataSource

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result

interface ILotteryRemoteDataSource {
    suspend fun getLotteryNumber(): Result<InvoiceNumber>
}
