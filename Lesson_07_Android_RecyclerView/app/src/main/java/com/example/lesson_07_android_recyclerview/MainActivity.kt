package com.example.lesson_07_android_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_07_android_recyclerview.data.PlaceListAdapter
import com.example.lesson_07_android_recyclerview.model.Place
import kotlinx.android.synthetic.main.activity_main.*

// This program allows the user to see a list of countries with its cities
// When clicked it displays the country name
class MainActivity : AppCompatActivity() {
    // Defines the variables
    private var adapter:PlaceListAdapter?=null
    private var countryList:ArrayList<Place>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configures the variables
        countryList=ArrayList<Place>()
        layoutManager=LinearLayoutManager(this)
        adapter=PlaceListAdapter(countryList!!,this)

        // Initializes the RecyclerView
        myRecyclerView.layoutManager=layoutManager
        myRecyclerView.adapter=adapter
        
        //load data
        // This is the list of countries
        var countryNameList:Array<String> = arrayOf("Canada","USA","Mexico","Columbia","Malaysia","Singapore","Turkey","Nicaragua","India","Italy","Tunisia","Chile","Argentina","Spain","Peru")
        // This is the list of cities
        var citiesNameList:Array<String> = arrayOf("Ottawa","Washington, D.C.","Mexico City","Bogotá","Kuala Lumpur","Singapore","Ankara","Managua","New Delhi","Rome","Tunis","Santiago","Buenos Aires","Madrid", "Lima")

        // The loop gets the name of each country and its corresponding city
        for (i in 0..14){
            var place=Place()
            place.CountryName = countryNameList[i]
            place.CityName = citiesNameList[i]
            countryList?.add(place)
        }
        // Notifies if the data set has changed
        adapter!!.notifyDataSetChanged()
    }
}