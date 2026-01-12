package com.example.invoiceapp.DataSource

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result

interface IInvoiceDataSource {
    suspend fun insertInvoice(invoice: InvoiceNumber)

    suspend fun getInvoice(): Result<InvoiceNumber>
}
