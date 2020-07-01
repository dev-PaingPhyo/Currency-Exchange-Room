package com.ppa.currencyexchangerate.dateformat

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getDateTime(timestamp: String) : String? {
    val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a")
    val netDate = Date(timestamp.toLong() * 1000)
    return sdf.format(netDate)
}