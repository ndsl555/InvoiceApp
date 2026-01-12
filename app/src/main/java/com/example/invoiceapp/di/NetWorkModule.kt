package com.example.invoiceapp.di

import com.example.invoiceapp.DataSource.ILotteryRemoteDataSource
import com.example.invoiceapp.NetWork.LotteryService
import com.example.invoiceapp.dataSource.LotteryDataRemoteSource
import com.google.gson.GsonBuilder
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule =
    module {
        single {
            GsonBuilder()
                .setLenient()
                .create()
        }

        single(named("lotteryRetrofit")) {
            Retrofit.Builder()
                .baseUrl("https://invoice.etax.nat.gov.tw/")
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
        }

        factory {
            get<Retrofit>(named("lotteryRetrofit")).create(LotteryService::class.java)
        }

        factory<ILotteryRemoteDataSource> { LotteryDataRemoteSource(get(), get(koinIO)) }
    }
