package com.java.a17_vaccines_app


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemClickListener {

    //1 AdapterView : RecyclerView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewContent)

        //Adapter

        //Data Sebagai Parameter pada konstruktor MyAdapter ( adapter bridge between data dan view)
        val adapter = MyAdapter(MenuClassModel.menuModel)
        //set fixed sizes true
        recyclerView.setHasFixedSize(true)

        //define layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        //assign adapter pada recyclerview ssuai adapter diatas
        recyclerView.adapter = adapter
        adapter.setItemClickListener(this@MainActivity)
    }

    override fun onClick(view: View, pos: Int) {
        //params view dan adapternya diinputkan dari MyAdapter, implementasinya di MainActivity
        Log.d("ini_debug","Di onClick Main")
        Toast.makeText(this, "Vaccine Name ${MenuClassModel.menuModel.get(pos).title}" ,Toast.LENGTH_SHORT).show()
    }
}