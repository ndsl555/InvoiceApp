package com.example.invoiceapp

import android.app.Application
import com.example.invoiceapp.di.dataModule
import com.example.invoiceapp.di.databaseModule
import com.example.invoiceapp.di.ioDispatcherModule
import com.example.invoiceapp.di.moshiModule
import com.example.invoiceapp.di.networkModule
import com.example.invoiceapp.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InvoiceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InvoiceApplication)
            modules(
                databaseModule,
                dataModule,
                viewModule,
                ioDispatcherModule,
                moshiModule,
                networkModule,
            )
        }
    }
}
