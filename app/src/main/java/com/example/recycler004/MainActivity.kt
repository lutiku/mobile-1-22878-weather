package com.example.recycler004

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.city_row.view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.setBackgroundColor(Color.WHITE)


        recyclerView_main.layoutManager = LinearLayoutManager(this)
        
        recyclerView_main.adapter = MainAdapter()


    }


}

 class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

     val cities = listOf(

         City("Vancouver", "CA"),City("Montreal", "CA"),City("Auckland", "NZ"),City("Amsterdam", "NL"),City("Copenhagen", "DK"),City("Dublin", "IE"),City("London", "GB"),City("Paris", "FR")
     )

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       //  TODO("Not yet implemented")

         val layoutInflater = LayoutInflater.from(parent?.context)

         val cellForRow = layoutInflater.inflate(R.layout.city_row, parent, false)

         return CustomViewHolder(cellForRow)

     }

     override fun getItemCount(): Int {
         // TODO("Not yet implemented")

         return cities.size
     }

     override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
          // TODO("Not yet implemented")

         holder.itemView.cityName.text = cities[position].name
        // holder.itemView.userAge.text = cities[position].age.toString()
         holder.itemView.cityCountry.text = cities[position].country

         holder?.city = cities[position]

     }

 }

class CustomViewHolder(view: View, var city:City? = null) : RecyclerView.ViewHolder(view){

    companion object {

        val LOGCAT_CATEGORY = "JSON"
        val DETAIL_TITLE_KEY = "ActionBarTitle"
       // val CITY_NAME = "CITY_NAME"
        val CITY_COUNTRY = "CITY_COUNTRY"


    }


    init {
        view.setOnClickListener {

            Log.i(LOGCAT_CATEGORY,"Recycler view Item has been clicked")
          Log.i(LOGCAT_CATEGORY, "Name is " + city?.name)
            Log.i(LOGCAT_CATEGORY, "Country is " + city?.country)
           // Log.i(LOGCAT_CATEGORY, "Phone number is "+city?.phoneNumber)

            val intent = Intent(view.context, RecyclerDetailActivity::class.java)

            /*Donne La bonne page détail gràace à la clé nom qui est unique */

            intent.putExtra(DETAIL_TITLE_KEY,"Details on " + city?.name )
            //intent.putExtra(USER_AGE, city?.age.toString())
            intent.putExtra(CITY_COUNTRY, city?.country)



            view.context.startActivity(intent)
        }

    }


}
