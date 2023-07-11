package com.java.a17_vaccines_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    val menuClassModel: ArrayList<MenuClassModel>,
    ) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {
    //1^ Define Constructor ( Data Resources)

    private lateinit var itemClickListener : ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }



    //2 View Holder Class
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textView: TextView = view.findViewById(R.id.textVacinne)
        val imageView: ImageView = view.findViewById(R.id.imgItem)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            itemClickListener?.onClick(v, adapterPosition)
        }
    }



    //3 Implements Method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Crate View (Moment of inflating)
        val inflater = LayoutInflater.from(parent.context)
        val listItem = inflater.inflate(R.layout.item_view, parent, false)
        return  MyViewHolder(listItem) //ViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val myListData : MenuClassModel = menuClassModel[position]
        holder.textView.text = myListData.title
        holder.imageView.setImageResource(myListData.imgFlag)
    }

    override fun getItemCount(): Int {
        return menuClassModel.size
    }

    // 4 Handling CLick Event
}