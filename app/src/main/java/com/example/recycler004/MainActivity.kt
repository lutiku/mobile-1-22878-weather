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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler_detail.view.*
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

         City("https://i.pinimg.com/564x/6c/d4/80/6cd48050e75735c141df980072c4d1bc.jpg","Vancouver", "CA"),City("https://i.pinimg.com/564x/e7/48/0d/e7480d437cb461fd7b2f19e74fee6716.jpg","Montreal", "CA"),City("https://i.pinimg.com/236x/d4/6c/a0/d46ca0d07fb887f260a9e1f419a3fc2a.jpg","Auckland", "NZ"),City("https://i.pinimg.com/564x/b6/9d/3c/b69d3c02719721123d56b83dfe206aa6.jpg","Amsterdam", "NL"),City("https://i.pinimg.com/236x/16/7c/b5/167cb5347051da27571c5f9054141d4b.jpg","Copenhagen", "DK"),City("https://i.pinimg.com/236x/dd/49/67/dd49675ce605efba2da7ae50b322752e.jpg","Dublin", "IE"),City("https://i.pinimg.com/236x/90/8e/b4/908eb4ad64a8a0f7a0ecfab8bd5c4c70.jpg","London", "GB"),City("https://i.pinimg.com/236x/4a/50/fe/4a50fe06a53e681dc819ff046c98e4e6.jpg","Paris", "FR")
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
         //holder.itemView.iv_image.srcCompat = cities[position].image
         holder.itemView.cityName.text = cities[position].name
        // holder.itemView.userAge.text = cities[position].age.toString()
         holder.itemView.cityCountry.text = cities[position].country

         val image = holder?.itemView?.cityImage

         Picasso.with(holder?.itemView?.context).load(cities[position].image).into(image)





         holder?.city = cities[position]



     }

 }

class CustomViewHolder(view: View, var city:City? = null) : RecyclerView.ViewHolder(view){

    companion object {

        val LOGCAT_CATEGORY = "JSON"
        val DETAIL_TITLE_KEY = "ActionBarTitle"
       val CITY_NAME = "CITY_NAME"
        val CITY_COUNTRY = "CITY_COUNTRY"
        val CITY_IMAGE = "CITY_IMAGE"


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
            intent.putExtra(CITY_NAME, city?.name)
            intent.putExtra(CITY_COUNTRY, city?.country)
            intent.putExtra(CITY_IMAGE, city?.image)



            view.context.startActivity(intent)
        }

    }


}
