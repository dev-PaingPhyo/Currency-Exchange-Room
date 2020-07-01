package com.ppa.currencyexchangerate.model

import com.google.gson.annotations.SerializedName

data class CentralResponse(

	@field:SerializedName("rates")
	val rates: Rates? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("info")
	val info: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)

data class Rates(

	@field:SerializedName("CHF")
	val cHF: String? = null,

	@field:SerializedName("SAR")
	val sAR: String? = null,

	@field:SerializedName("ZAR")
	val zAR: String? = null,

	@field:SerializedName("INR")
	val iNR: String? = null,

	@field:SerializedName("VND")
	val vND: String? = null,

	@field:SerializedName("CNY")
	val cNY: String? = null,

	@field:SerializedName("THB")
	val tHB: String? = null,

	@field:SerializedName("AUD")
	val aUD: String? = null,

	@field:SerializedName("KRW")
	val kRW: String? = null,

	@field:SerializedName("ILS")
	val iLS: String? = null,

	@field:SerializedName("NPR")
	val nPR: String? = null,

	@field:SerializedName("JPY")
	val jPY: String? = null,

	@field:SerializedName("BDT")
	val bDT: String? = null,

	@field:SerializedName("KHR")
	val kHR: String? = null,

	@field:SerializedName("GBP")
	val gBP: String? = null,

	@field:SerializedName("IDR")
	val iDR: String? = null,

	@field:SerializedName("PHP")
	val pHP: String? = null,

	@field:SerializedName("KWD")
	val kWD: String? = null,

	@field:SerializedName("RUB")
	val rUB: String? = null,

	@field:SerializedName("HKD")
	val hKD: String? = null,

	@field:SerializedName("RSD")
	val rSD: String? = null,

	@field:SerializedName("EUR")
	val eUR: String? = null,

	@field:SerializedName("DKK")
	val dKK: String? = null,

	@field:SerializedName("USD")
	val uSD: String? = null,

	@field:SerializedName("MYR")
	val mYR: String? = null,

	@field:SerializedName("CAD")
	val cAD: String? = null,

	@field:SerializedName("NOK")
	val nOK: String? = null,

	@field:SerializedName("EGP")
	val eGP: String? = null,

	@field:SerializedName("SGD")
	val sGD: String? = null,

	@field:SerializedName("LKR")
	val lKR: String? = null,

	@field:SerializedName("CZK")
	val cZK: String? = null,

	@field:SerializedName("PKR")
	val pKR: String? = null,

	@field:SerializedName("LAK")
	val lAK: String? = null,

	@field:SerializedName("SEK")
	val sEK: String? = null,

	@field:SerializedName("KES")
	val kES: String? = null,

	@field:SerializedName("NZD")
	val nZD: String? = null,

	@field:SerializedName("BND")
	val bND: String? = null,

	@field:SerializedName("BRL")
	val bRL: String? = null
)
