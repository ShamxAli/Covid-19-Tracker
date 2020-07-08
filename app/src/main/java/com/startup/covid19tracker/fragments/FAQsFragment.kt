package com.startup.covid19tracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.startup.covid19tracker.R
import com.startup.covid19tracker.models.Pakistan
import com.startup.covid19tracker.networking.CovidAPI
import com.startup.covid19tracker.networking.RetrofitClient
import com.startup.covid19tracker.utils.showToast
import kotlinx.android.synthetic.main.fragment_f_a_qs.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.text.NumberFormat
import java.util.*


class FAQsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_a_qs, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val retrofitClient = RetrofitClient.buildService(CovidAPI::class.java)
        val requestCall = retrofitClient.getCountry()

        requestCall.enqueue(object : Callback<Pakistan> {

            override fun onResponse(call: Call<Pakistan>, response: Response<Pakistan>) {

                if (response.isSuccessful) {
                    val pakistan = response.body()
                    try {

                        pakistan?.let {

                            pk_total.text = NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(it.cases)

                            pk_active.text = NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(it.active)

                            pk_recovered.text = NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(it.recovered)

                            pk_deaths.text = NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(it.deaths)

                            pk_critical.text = NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(it.critical)

                            pk_today_new_cases.text =
                                NumberFormat.getNumberInstance(Locale.getDefault())
                                    .format(it.todayCases)

                            pk_today_deaths.text =
                                NumberFormat.getNumberInstance(Locale.getDefault())
                                    .format(it.todayDeaths)

                        }

                    } catch (e: Exception) {

                    }
                } else {
                    requireContext().showToast("Data is not loading")

                }


            }

            override fun onFailure(call: Call<Pakistan>, t: Throwable) {
                requireContext().showToast("_pk Some Server Error")
            }

        })


    }

}