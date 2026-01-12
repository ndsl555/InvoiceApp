package com.example.invoiceapp.di

import com.example.invoiceapp.Repository.IInvoiceRepository
import com.example.invoiceapp.Repository.ILotteryRepository
import com.example.invoiceapp.Repository.InvoiceRepository
import com.example.invoiceapp.Repository.LotteryRepository
import org.koin.dsl.module

val dataModule =
    module {
        includes(ioDispatcherModule, moshiModule, databaseModule)
        factory<ILotteryRepository> { LotteryRepository(get()) }
        factory<IInvoiceRepository> { InvoiceRepository(get(koinIO), get()) }
    }
