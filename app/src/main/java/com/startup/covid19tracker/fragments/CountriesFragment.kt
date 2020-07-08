package com.startup.covid19tracker.fragments

import Countries
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.startup.covid19tracker.R
import com.startup.covid19tracker.adapters.CountriesAdapter
import com.startup.covid19tracker.networking.CovidAPI
import com.startup.covid19tracker.networking.RetrofitClient
import com.startup.covid19tracker.utils.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CountriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        val retrofitClient = RetrofitClient.buildService(CovidAPI::class.java)
        val requestCall = retrofitClient.getAllCountries()

        requestCall.enqueue(object : Callback<List<Countries>> {


            override fun onResponse(
                call: Call<List<Countries>>, response: Response<List<Countries>>
            ) {

                if (response.isSuccessful) {
                    val countriesList = response.body()

                    val layoutManager = LinearLayoutManager(requireContext())
                    layoutManager.orientation = LinearLayoutManager.VERTICAL
                    recyclerView.layoutManager = layoutManager

                    // sorting the list
                    val sortedList = countriesList?.sortedWith(compareByDescending({ it.cases }))

                    recyclerView.adapter =
                        sortedList?.let { CountriesAdapter(requireContext(), sortedList) }
                }
            }


            override fun onFailure(call: Call<List<Countries>>, t: Throwable) {
                requireContext().showToast("server error")
            }
        })


    }

}