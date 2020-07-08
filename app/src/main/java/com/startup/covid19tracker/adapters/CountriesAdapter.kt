package com.startup.covid19tracker.adapters

import Countries
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.startup.covid19tracker.R
import com.startup.covid19tracker.activities.DetailsActivity
import kotlinx.android.synthetic.main.layout_design.view.*
import java.text.NumberFormat
import java.util.*


class CountriesAdapter(val context: Context, val list: List<Countries>) :
    RecyclerView.Adapter<CountriesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_design, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val countries = list[position]

        // passing data to ViewHolder for showing
        holder.setData(countries, position)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("object", countries)
            intent.putExtra("position", position + 1) // as index starts at 0, we req 1 to onward
            context.startActivity(intent)

        }


    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setData(countries: Countries, position: Int) {
            itemView.country_name.text = countries.country
            itemView.country_rank.text = (position + 1).toString() // show the rank
            Glide.with(context).load(countries.countryInfo.flag).into(itemView.country_flag)
            itemView.num_of_cases.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.cases)
        }


    }
}