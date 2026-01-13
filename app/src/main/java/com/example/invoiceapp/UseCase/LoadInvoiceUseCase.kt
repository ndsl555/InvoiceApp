package com.example.invoiceapp.UseCase

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Repository.IInvoiceRepository
import com.example.invoiceapp.Utils.Result
import com.example.invoiceapp.Utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class LoadInvoiceUseCase(val invoiceRepository: IInvoiceRepository, dispatcher: CoroutineDispatcher) :
    UseCase<Unit, InvoiceNumber>(dispatcher) {
    override suspend fun execute(parameters: Unit): Result<InvoiceNumber> {
        return invoiceRepository.getInvoice()
    }
}
