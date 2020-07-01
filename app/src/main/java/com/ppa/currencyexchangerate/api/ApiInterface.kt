package com.ppa.currencyexchangerate.api


import com.ppa.currencyexchangerate.model.CentralResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("latest")
    fun getLatest() : Call<CentralResponse>
}
