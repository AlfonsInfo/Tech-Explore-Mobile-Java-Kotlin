package com.java.a25_contactmanagerapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private  var DATABASE_VERSION = 1
        private  var DATABASE_NAME = "contact_db_2"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //Create Table
        db?.execSQL(Contact.CREATE_TABLE)
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Drop Table
        db?.execSQL(Contact.DROP_TABLE)
        //Run ulang Code
        onCreate(db)
    }

     fun insertContact(name : String, email : String) : Long{
        val db = this.writableDatabase
        val values = ContentValues()
         values.put(Contact.COLUMN_NAME,name)
         values.put(Contact.COLUMN_CONTACT_INFO, email)

         val id = db.insert(Contact.TABLE_NAME, null, values)

         db.close()
         return id
    }


    fun getContact(id : Long) : Contact {
        val db = this.readableDatabase
        val cursor = db.query(
            Contact.TABLE_NAME,
            arrayOf(
                Contact.COLUMN_ID,
                Contact.COLUMN_NAME,
                Contact.COLUMN_CONTACT_INFO
                ),
            "${Contact.COLUMN_ID} =?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        if(cursor != null){
            cursor.moveToFirst()
        }
        val contact = Contact(
            cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_NAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_CONTACT_INFO)),
            cursor.getInt(cursor.getColumnIndexOrThrow(Contact.COLUMN_ID))

        )

        cursor.close()
        return contact
    }


    fun getAllContact() : ArrayList<Contact>{
        val contacts = ArrayList<Contact>()

        val selectQuery = "SELECT * FROM ${Contact.TABLE_NAME} ORDER BY ${Contact.COLUMN_ID} DESC"

//        val db = this.writableDatabase
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery,null)

        if(cursor.moveToFirst()){
            do{
                val contact = Contact(
                    cursor.getString( cursor.getColumnIndexOrThrow(Contact.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_CONTACT_INFO)) ,
                    cursor.getInt(cursor.getColumnIndexOrThrow(Contact.COLUMN_ID)) )
                contacts.add(contact)


            }while (cursor.moveToNext())

        }
        cursor.close()
        db.close()
        return contacts
    }


    fun updateContact(contact: Contact) : Int{
        val db= this.writableDatabase

        val values = ContentValues()
        values.put(Contact.COLUMN_NAME, contact.name)
        values.put(Contact.COLUMN_CONTACT_INFO, contact.contactInfo)

        return db.update(
            Contact.TABLE_NAME, values, "${Contact.COLUMN_ID} =?",
            arrayOf(contact.id.toString()),
        )
    }

    fun deleteContact(contact: Contact){
        val db = this.writableDatabase
        db.delete(
            Contact.TABLE_NAME,"${Contact.COLUMN_ID} =?",
            arrayOf(contact.id.toString()),
        )
    }


}