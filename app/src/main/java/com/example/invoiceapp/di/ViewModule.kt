package com.example.invoiceapp.di

import com.example.invoiceapp.ViewModel.LotteryCheckViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModule: Module =
    module {
        includes(ioDispatcherModule, domainModule, moshiModule)
        viewModel { LotteryCheckViewModel(get()) }
    }
