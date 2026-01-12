package com.example.invoiceapp.UseCase

import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Repository.IInvoiceRepository
import com.example.invoiceapp.Utils.Result
import com.example.invoiceapp.Utils.Result.Success
import com.example.invoiceapp.Utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class SaveInvoiceUseCase(val invoiceRepository: IInvoiceRepository, dispatcher: CoroutineDispatcher) :
    UseCase<SaveInvoiceUseCase.Parameters, Unit>(dispatcher) {
    override suspend fun execute(parameters: Parameters): Result<Unit> {
        invoiceRepository.insertInvoice(
            parameters.invoiceNumber,
        )
        return Success(Unit)
    }

    data class Parameters(
        val invoiceNumber: InvoiceNumber,
    )
}
