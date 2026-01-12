package com.example.invoiceapp.di

import com.example.invoiceapp.UseCase.LotteryCheckUseCase
import org.koin.dsl.module

val domainModule =
    module {
        includes(ioDispatcherModule, dataModule, moshiModule)
        factory { LotteryCheckUseCase(get(), get(koinIO)) }
    }
