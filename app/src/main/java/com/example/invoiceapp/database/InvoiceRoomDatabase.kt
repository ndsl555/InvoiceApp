package com.example.invoiceapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.invoiceapp.Database.Converters
import com.example.invoiceapp.Entity.InvoiceNumber

@Database(
    entities = [
        InvoiceNumber::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class InvoiceRoomDatabase : RoomDatabase(), InvoiceDatabase {
    companion object {
        const val DATABASE_NAME = "Invoice.db"
    }
}
