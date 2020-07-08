package com.startup.covid19tracker.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.startup.covid19tracker.R
import com.startup.covid19tracker.models.WholeWorld
import com.startup.covid19tracker.networking.CovidAPI
import com.startup.covid19tracker.networking.RetrofitClient
import kotlinx.android.synthetic.main.fragment_home.*
import org.eazegraph.lib.models.PieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat


class HomeFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val retrofitClient = RetrofitClient.buildService(CovidAPI::class.java)
        val requestCall = retrofitClient.getDestinationList()

        requestCall.enqueue(object : Callback<WholeWorld> {

            override fun onResponse(call: Call<WholeWorld>, response: Response<WholeWorld>) {
                if (response.isSuccessful) {
                    val wholeWorld = response.body()

                    wholeWorld?.let {
                        try {
                            w_totalCases.text = wholeWorld.cases.toString()
                            w_totalActiveCases.text = wholeWorld.active.toString()
                            w_totalRecoveredCases.text = wholeWorld.recovered.toString()
                            w_totalDeaths.text = wholeWorld.deaths.toString()
                            w_totalCritical.text = wholeWorld.critical.toString()
                            w_totalTodayCases.text = wholeWorld.todayCases.toString()


                            /* ========  Pie Chart =========*/
                            activity_main_piechart.addPieSlice(
                                PieModel(
                                    "Active",
                                    Integer.parseInt(it.cases.toString()).toFloat(),
                                    Color.parseColor("#007afe")
                                )
                            )
                            activity_main_piechart.addPieSlice(
                                PieModel(
                                    "Recovered",
                                    Integer.parseInt(it.recovered.toString()).toFloat(),
                                    Color.parseColor("#7EC544")
                                )
                            )
                            activity_main_piechart.addPieSlice(
                                PieModel(
                                    "Deaths",
                                    Integer.parseInt(it.deaths.toString()).toFloat(),
                                    Color.parseColor("#F6404F")
                                )
                            )
                            /* ========  Pie Chart =========*/

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }
                }
            }

            override fun onFailure(call: Call<WholeWorld>, t: Throwable) {

            }

        })


    }
}