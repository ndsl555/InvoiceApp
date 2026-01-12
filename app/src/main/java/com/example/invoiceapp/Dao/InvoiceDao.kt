package com.example.invoiceapp.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.invoiceapp.Entity.InvoiceNumber

@Dao
interface InvoiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoice(invoiceNumber: InvoiceNumber)

    @Query("SELECT * FROM invoicetable LIMIT 1")
    suspend fun getInvoice(): InvoiceNumber
}
