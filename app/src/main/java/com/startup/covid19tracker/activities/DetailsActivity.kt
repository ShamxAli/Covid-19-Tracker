package com.startup.covid19tracker.activities

import Countries
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.startup.covid19tracker.R
import com.startup.covid19tracker.fragments.CountriesFragment
import kotlinx.android.synthetic.main.activity_details.*
import java.text.NumberFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Getting parcelable object for details activity
        val countries = intent.getParcelableExtra<Countries>("object")
        // position to show rank in list
        val position = intent.getIntExtra("position", 0)
        showData(countries, position)
    }

    private fun showData(countries: Countries?, position: Int?) {

        countries?.let {
            d_cases.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.cases)
            d_active.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.active)
            d_today_deaths.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.todayDeaths)
            d_today_cases.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.todayCases)
            d_critical.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.critical)
            d_total_tests.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.tests)
            d_recovered.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.recovered)

            d_country.text = countries.country
            d_rank.text = (position).toString()

        }

    }
}