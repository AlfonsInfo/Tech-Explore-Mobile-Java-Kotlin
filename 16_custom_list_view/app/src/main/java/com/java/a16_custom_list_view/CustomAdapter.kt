package com.java.a16_custom_list_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(
    private val context: Context,
    countryArrayList: ArrayList<CountryModelClass>
) : ArrayAdapter<CountryModelClass>(context, R.layout.item_list_layout, countryArrayList) {

    private class ViewHolder {
        var countryName: TextView? = null
        var countWin: TextView? = null
        var countryFlag: ImageView? = null
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false)

            viewHolder = ViewHolder()
            viewHolder.countryName = convertView.findViewById(R.id.country_name)
            viewHolder.countWin = convertView.findViewById(R.id.countwin)
            viewHolder.countryFlag = convertView.findViewById(R.id.country_flag)

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        val dataModel: CountryModelClass? = getItem(position)

        viewHolder.countryName?.text = dataModel?.countryName
        viewHolder.countWin?.text = dataModel?.winCount.toString()
        viewHolder.countryFlag?.setImageResource(dataModel?.imageFlag ?: R.drawable.ic_launcher_background)

        return convertView!!
    }

}
