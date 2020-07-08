package com.startup.covid19tracker.adapters

import Countries
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.startup.covid19tracker.R


class CountriesAdapter(val context: Context, val list: List<Countries>) :
    RecyclerView.Adapter<CountriesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_design, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val countries = list[position]

        holder.countryName.text = countries.country
        holder.numberOfCases.text = countries.cases.toString()
        Glide.with(context).load(countries.countryInfo.flag).into(holder.countryFlag)

    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryFlag: ImageView = itemView.findViewById(R.id.country_flag)
        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val numberOfCases = itemView.findViewById<TextView>(R.id.num_of_cases)
    }


}