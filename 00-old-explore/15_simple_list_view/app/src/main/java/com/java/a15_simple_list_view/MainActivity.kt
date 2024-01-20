package com.java.a15_simple_list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    //init adapter view
    private lateinit var listview : ListView

    //define Data
    companion object{
        var wordCupCountry = arrayOf(
            "Indonesia",
            "Germany",
            "Spain",
            "England"
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //define View Adapter
        listview = findViewById(R.id.lvContainer)

        val adapter = ArrayAdapter(
            this,
            R.layout.my_list_layout,
            R.id.textView,
            //android.R.layout.simple_list_item_1,
            wordCupCountry
        )

        listview.adapter = adapter

    }
}