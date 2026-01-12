package com.example.invoiceapp.database

import com.example.invoiceapp.Dao.InvoiceDao

interface InvoiceDatabase {
    fun invoiceDao(): InvoiceDao
}
