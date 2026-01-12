package com.example.invoiceapp.Repository

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result

interface IInvoiceRepository {
    suspend fun insertInvoice(invoice: InvoiceNumber)

    suspend fun getInvoice(): Result<InvoiceNumber>
}
