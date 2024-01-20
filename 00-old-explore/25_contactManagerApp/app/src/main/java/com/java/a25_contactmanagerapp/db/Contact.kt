package com.java.a25_contactmanagerapp.db

class Contact(var name : String, var contactInfo : String, var id : Int) {
    companion object {
        const val TABLE_NAME = "contacts"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CONTACT_INFO = "phone"
        const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_CONTACT_INFO TEXT)"
//        const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_NAME, $COLUMN_CONTACT_INFO , $COLUMN)"
        const val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}