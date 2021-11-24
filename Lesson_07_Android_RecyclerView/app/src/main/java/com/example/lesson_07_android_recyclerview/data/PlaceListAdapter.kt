package com.example.lesson_07_android_recyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.lesson_07_android_recyclerview.model.Place
import com.example.lesson_07_android_recyclerview.R

class PlaceListAdapter(private val list:ArrayList<Place>, private val context: Context):RecyclerView.Adapter<PlaceListAdapter.ViewHolder>()
{

    // This will display the data at a specified position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    // This will create a view fro, the card layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    // This gets the list size
    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // This binds the country and city together
        fun bindItem(place:Place){
            var country:TextView=itemView.findViewById(R.id.country_ID) as TextView
            var city:TextView=itemView.findViewById(R.id.city_ID) as TextView
            country.text=place.CountryName
            city.text=place.CityName

            // When the item is clicked, the country is displayed
            itemView.setOnClickListener {Toast.makeText(context, country.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}