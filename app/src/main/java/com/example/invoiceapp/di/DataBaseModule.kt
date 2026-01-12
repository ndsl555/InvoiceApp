package com.example.invoiceapp.di

import androidx.room.Room
import com.example.invoiceapp.DataSource.IInvoiceDataSource
import com.example.invoiceapp.DataSource.InvoiceDataSource
import com.example.invoiceapp.Transaction.DatabaseTransactionRunner
import com.example.invoiceapp.Transaction.RoomTransactionRunner
import com.example.invoiceapp.database.InvoiceDatabase
import com.example.invoiceapp.database.InvoiceRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import kotlin.jvm.java

val databaseModule =
    module {
        single {
            val builder =
                Room.databaseBuilder(
                    androidContext(),
                    InvoiceRoomDatabase::class.java,
                    InvoiceRoomDatabase.DATABASE_NAME,
                )
            builder
                .build()
        }
        single { get<InvoiceRoomDatabase>() as InvoiceDatabase }
        single<DatabaseTransactionRunner> { RoomTransactionRunner(get()) }

        // Dao
        factory { get<InvoiceRoomDatabase>().invoiceDao() }

        // DataSource
        factory<IInvoiceDataSource> { InvoiceDataSource(get(), get(koinIO)) }
    }
