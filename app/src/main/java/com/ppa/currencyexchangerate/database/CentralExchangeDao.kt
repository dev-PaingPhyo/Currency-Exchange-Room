package com.ppa.currencyexchangerate.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CentralExchangeDao {
    @Insert
    fun create(centralExchange: CentralExchange)

    @Query("select * from CentralExchange")
    fun getCentralExchange() : List<CentralExchange>
}