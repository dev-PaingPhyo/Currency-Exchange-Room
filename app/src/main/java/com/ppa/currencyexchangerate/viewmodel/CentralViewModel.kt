package com.ppa.currencyexchangerate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ppa.currencyexchangerate.api.ApiClient

import com.ppa.currencyexchangerate.model.CentralResponse
import retrofit2.Call
import retrofit2.Response

class CentralViewModel : ViewModel(){
    var result : MutableLiveData<CentralResponse> = MutableLiveData()

    var error : MutableLiveData<Boolean> = MutableLiveData()

    var loading : MutableLiveData<Boolean> = MutableLiveData()

    fun getResult() : LiveData<CentralResponse> = result

    fun getError() : LiveData<Boolean> = error

    fun getLoading() : LiveData<Boolean> = loading

    fun loadResult() {
        loading.value = true
        val call = ApiClient().getResults()
        call.enqueue(object : retrofit2.Callback<CentralResponse>{
            override fun onFailure(call: Call<CentralResponse>, t: Throwable) {
                error.value = true
                loading.value = false
            }

            override fun onResponse(
                call: Call<CentralResponse>,
                response: Response<CentralResponse>
            ) {
                response.isSuccessful.let {
                    loading.value = false
                    result.value = CentralResponse(response.body()?.rates)
                }
            }

        })
    }
}