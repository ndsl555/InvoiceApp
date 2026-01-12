package com.example.invoiceapp.DataSource

import com.example.invoiceapp.Dao.InvoiceDao
import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class InvoiceDataSource(
    private val dao: InvoiceDao,
    private val ioDispatcher: CoroutineDispatcher,
) : IInvoiceDataSource {
    override suspend fun insertInvoice(invoice: InvoiceNumber) =
        withContext(ioDispatcher) {
            dao.insertInvoice(invoice)
        }

    override suspend fun getInvoice(): Result<InvoiceNumber> =
        withContext(ioDispatcher) {
            return@withContext try {
                val bar = dao.getInvoice()
                Result.Success(bar)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}
