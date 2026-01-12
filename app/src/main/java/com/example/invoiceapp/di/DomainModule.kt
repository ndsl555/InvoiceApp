package com.example.invoiceapp.di

import com.example.invoiceapp.UseCase.LoadBarCodeUseCase
import com.example.invoiceapp.UseCase.LotteryCheckUseCase
import com.example.invoiceapp.UseCase.SaveInvoiceUseCase
import org.koin.dsl.module

val domainModule =
    module {
        includes(ioDispatcherModule, dataModule, moshiModule)
        factory { LotteryCheckUseCase(get(), get(koinIO)) }
        factory { SaveInvoiceUseCase(get(), get(koinIO)) }
        factory { LoadBarCodeUseCase(get(), get(koinIO)) }
    }
