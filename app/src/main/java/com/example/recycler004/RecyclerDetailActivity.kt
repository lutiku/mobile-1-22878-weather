package com.example.recycler004

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_detail.*

class RecyclerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_detail)

        val title = intent.getStringExtra(CustomViewHolder.DETAIL_TITLE_KEY)
        supportActionBar?.title = title

        userAgeTextView.text = intent.getStringExtra(CustomViewHolder.CITY_COUNTRY)

        //userPhoneTextView.text = intent.getStringExtra(CustomViewHolder.USER_PHONE)

    }
}
