package com.startup.covid19tracker.networking


import Countries
import com.startup.covid19tracker.models.Pakistan
import com.startup.covid19tracker.models.WholeWorld
import retrofit2.Call
import retrofit2.http.GET


interface CovidAPI {

    // Get data world widely
    @GET("v3/covid-19/all")
    fun getDestinationList(): Call<WholeWorld>


    // Get all countries
    @GET("v3/covid-19/countries")
    fun getAllCountries(): Call<List<Countries>>

    @GET("v3/covid-19/countries/pakistan")
    fun getCountry(): Call<Pakistan>

}