package com.java.a25_contactmanagerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.java.a25_contactmanagerapp.MainActivity
import com.java.a25_contactmanagerapp.R
import com.java.a25_contactmanagerapp.db.Contact

class ContactsAdapter(var context: Context, var contactsList : ArrayList<Contact>, mainActivity: MainActivity) : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {



    inner class MyViewHolder(itemView : View, var name : TextView = itemView.findViewById(R.id.name), var  email : TextView = itemView.findViewById(
        R.id.email
    )) : RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = contactsList.get(position)

        holder.name.setText(contact.name)
        holder.email.setText(contact.contactInfo)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

}