package com.example.invoiceapp.Repository

import com.example.invoiceapp.DataSource.ILotteryRemoteDataSource
import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.Utils.Result

class LotteryRepository(private val lotteryDataRemoteSource: ILotteryRemoteDataSource) : ILotteryRepository {
    override suspend fun getLotteryNumber(): Result<InvoiceNumber> {
        return lotteryDataRemoteSource.getLotteryNumber()
    }
}
