package com.java.a23_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gridView = findViewById(R.id.gridView)
        //Define the GridView Layout -> horizontal spacaing dan vertical spacing, num columns
        //Define card , layout_gravitiy, cornerRadius, elevation
        //Using Array Adapter

//        var dataCourse  = ArrayListOf<CourseModel>()
//        CourseModel.dataCourse.add(CourseModel("Course 1", R.drawable.ic_launcher_background))
//        CourseModel.dataCourse.add(CourseModel("Course 2", R.drawable.ic_launcher_background))
//        CourseModel.dataCourse.add(CourseModel("Course 3", R.drawable.ic_launcher_background))

        Log.d("datanya", CourseModel.dataCourse.toString()  )
        //Define ADapter
        val myAdapter = MyAdapter(this,CourseModel.dataCourse)
        gridView.adapter = myAdapter

        //Set Adapter
    }
}