package com.java.a18_implements_card_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//data -> context & adapter langsung dengan constructor di definisi nama class jika di kotlin
class GameAdapter(var context: Context, var listGame : ArrayList<GameModel>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

//viewHolder

    inner class ViewHolder(
        itemView: View,
        var imageView: ImageView = itemView.findViewById(R.id.imgViewCard),
        var textView: TextView = itemView.findViewById(R.id.textviewcard)
    ) : RecyclerView.ViewHolder(itemView) {

    }


    //Implements Method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.card_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = listGame.get(position)
        holder.textView.text = model.gameName
        holder.imageView.setImageResource(model.gameImg)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Mantap",Toast.LENGTH_SHORT).show()
        }
    }


    //kenapa saat var tidak ditulis tidak terdeteksi sebagai attribut ?
    override fun getItemCount(): Int {
        return listGame.size
    }


}