package com.startup.covid19tracker.models

// https://corona.lmao.ninja/v3/covid-19/countries/pakistan

data class Pakistan(
    val active: Int,
    val cases: Int,
    val country: String,
    val critical: Int,
    val deaths: Int,
    val recovered: Int,
    val todayCases: Int,
    val todayDeaths: Int
)