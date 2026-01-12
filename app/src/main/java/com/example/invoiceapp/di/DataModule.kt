package com.example.invoiceapp.di

import com.example.invoiceapp.Repository.ILotteryRepository
import com.example.invoiceapp.Repository.LotteryRepository
import org.koin.dsl.module

val dataModule =
    module {
        includes(ioDispatcherModule, moshiModule)
        factory<ILotteryRepository> { LotteryRepository(get()) }
    }
