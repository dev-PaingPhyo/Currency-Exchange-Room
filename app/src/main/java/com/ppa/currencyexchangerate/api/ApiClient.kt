package com.ppa.currencyexchangerate.api

import com.ppa.currencyexchangerate.model.CentralResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val apiInterface : ApiInterface

    companion object {
        const val BASE_URL = "https://forex.cbm.gov.mm/api/"
    }
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }
    fun getResults() : Call<CentralResponse>{
        return apiInterface.getLatest()
    }
}