package com.example.invoiceapp.Transaction

import androidx.room.withTransaction
import com.example.invoiceapp.database.InvoiceRoomDatabase

class RoomTransactionRunner(private val db: InvoiceRoomDatabase) : DatabaseTransactionRunner {
    override suspend fun <T> invoke(block: suspend () -> T): T {
        return db.withTransaction {
            block()
        }
    }
}
