package com.java.a16_custom_list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1 Adapter a ListView
        val listView : ListView = findViewById(R.id.listworldcupcontainer)

        //2 Data Source
        val dataModels = ArrayList<CountryModelClass>()
        dataModels.add(CountryModelClass("Germany","3",R.drawable.ic_launcher_foreground))
        dataModels.add(CountryModelClass("Indonesia","5",R.drawable.ic_launcher_background))

        //3 Adapter
        val adapter =  CustomAdapter(
            applicationContext,
            dataModels,
        )
        listView.adapter  = adapter

        //on click listener

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this@MainActivity,
                "Country ${adapter.getItem(position)?.countryName}",
                Toast.LENGTH_LONG
                ).show()
        }
    }
}