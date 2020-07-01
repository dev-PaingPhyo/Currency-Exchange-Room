package com.ppa.currencyexchangerate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CentralExchange::class],
    version = 1,
    exportSchema = false
)
abstract class CentralExchangeDatabase : RoomDatabase() {

    abstract fun centralExchangeDao(): CentralExchangeDao

    companion object {

        private lateinit var database: CentralExchangeDatabase

        fun get(context: Context) = if (::database.isInitialized)
            database
        else
            Room.databaseBuilder(
                context,
                CentralExchangeDatabase::class.java, "central_database"
            )
                .allowMainThreadQueries()
                .build()
                .also { database = it }
    }
}