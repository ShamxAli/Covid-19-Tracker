package com.startup.covid19tracker.networking


import com.startup.covid19tracker.models.WholeWorld
import retrofit2.Call
import retrofit2.http.GET


interface CovidAPI {

    @GET("v3/covid-19/all")
    fun getDestinationList(): Call<WholeWorld>

}