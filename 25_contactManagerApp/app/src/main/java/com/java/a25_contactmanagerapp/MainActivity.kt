package com.java.a25_contactmanagerapp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.java.a25_contactmanagerapp.adapter.ContactsAdapter
import com.java.a25_contactmanagerapp.db.Contact
import com.java.a25_contactmanagerapp.db.DatabaseHelper

class MainActivity : AppCompatActivity() {

    private lateinit var contactsAdapter : ContactsAdapter
    private var contactArrayList: ArrayList<Contact> = ArrayList<Contact>()
    private lateinit var recyclerView : RecyclerView
    private lateinit var db: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("My Favorite Contacts")

        recyclerView = findViewById(R.id.recycler_view_contacts)
        db = DatabaseHelper(this)
        contactArrayList.addAll(db.getAllContact())

        contactsAdapter =  ContactsAdapter(this, contactArrayList, MainActivity())

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager= layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = contactsAdapter

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            addAndEditContacts(false , null, -1)
        }
    }


    fun addAndEditContacts(isUpdated: Boolean, contact: Contact?, position: Int) {
        val layoutInflater = LayoutInflater.from(applicationContext)
        val view = layoutInflater.inflate(R.layout.layout_add_contact, null)
        val alerDialogBuilder = AlertDialog.Builder(this@MainActivity)
        alerDialogBuilder.setView(view)
        val contactTitle = view.findViewById<TextView>(R.id.new_contact_title)
        val newContact = view.findViewById<EditText>(R.id.name)
        val contactEmail = view.findViewById<EditText>(R.id.email)
        contactTitle.text = if (!isUpdated) "Add New Contact" else "Edit Contact"
        if (isUpdated && contact != null) {
            newContact.setText(contact.name)
            contactEmail.setText(contact.contactInfo)
        }
        alerDialogBuilder.setCancelable(false)
            .setPositiveButton(
                if (isUpdated) "Update" else "Save"
            ) { dialogInterface, i -> }
            .setNegativeButton(
                "Delete"
            ) { dialogInterface, i ->
                if (isUpdated) {
                    DeleteContact(contact, position)
                } else {
                    dialogInterface.cancel()
                }
            }
        val alertDialog = alerDialogBuilder.create()
        alertDialog.show()
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
            View.OnClickListener {
                if (TextUtils.isEmpty(newContact.text.toString())) {
                    Toast.makeText(this@MainActivity, "Please Enter a Name", Toast.LENGTH_SHORT)
                        .show()
                    return@OnClickListener
                } else {
                    alertDialog.dismiss()
                }
                if (isUpdated && contact != null) {
                    UpdateContact(
                        newContact.text.toString(),
                        contactEmail.text.toString(),
                        position
                    )
                } else {
                    CreateContact(newContact.text.toString(), contactEmail.text.toString())
                }
            })
    }


    private fun DeleteContact(contact: Contact?, position: Int){
        contactArrayList.removeAt(position)
        db.deleteContact(contact!!)
        contactsAdapter.notifyDataSetChanged()
    }

    private fun UpdateContact(name : String, email : String, position: Int){
        val contact = contactArrayList.get(position)
        contact.name  = name
        contact.contactInfo = email

        db.updateContact(contact)

        contactArrayList.set(position,contact)
        contactsAdapter.notifyDataSetChanged()
    }

    private fun CreateContact(name : String, email : String){
        val id : Long = db.insertContact(name,email)
        val contact = db.getContact(id)

        if (contact != null){
            contactArrayList.add(0, contact)
            contactsAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.action_settings){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}