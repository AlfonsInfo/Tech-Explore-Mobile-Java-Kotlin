package com.java.a23_gridview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(context: Context, courseModelArrayList: ArrayList<CourseModel>) : ArrayAdapter<CourseModel>(context,0,courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView : View? = convertView


        if(listItemView == null){
            listItemView = LayoutInflater.from(context).inflate(R.layout.grid_card_item,parent,false)
        }

        Log.d("LIST VIEW DIATAS", listItemView.toString())

        var courseModel : CourseModel? = getItem(position)
        var courseTitle : TextView = listItemView!!.findViewById(R.id.gridTextView)
        var courseImage : ImageView = listItemView!!.findViewById(R.id.gridImageView)

        courseTitle.setText(courseModel!!.courseName)
        courseImage.setImageResource(courseModel!!.coursImg)


        Log.d("LIST VIEW DIBAWAH", listItemView.toString())
        return listItemView
        //return super.getView(position, convertView, parent)
    }
}