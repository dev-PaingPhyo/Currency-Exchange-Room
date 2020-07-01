package com.ppa.currencyexchangerate.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CentralExchange(
    @PrimaryKey(autoGenerate = true)
    var centralRate: String,
    var centralFlag: Int,
    var centralName: String,
    var centralNameLong: String
)