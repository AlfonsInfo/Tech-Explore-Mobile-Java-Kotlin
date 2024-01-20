package com.java.a24_sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var inputText : EditText
    private lateinit var showText : TextView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.inputText)
        showText = findViewById(R.id.showText)
        button = findViewById(R.id.clickMeButton)

        DisplaySavedText()

        button.setOnClickListener {
            val enteredText = inputText.text.toString()
            DisplayAndSaveText(enteredText)
        }
    }

    private fun DisplaySavedText(){
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        val textFromSharedPreferences = sharedPreferences.getString("name", "mamak")

        showText.text = textFromSharedPreferences
    }

    private fun DisplayAndSaveText(enteredText : String){

        //Display the text
        showText.text = enteredText

        //Save the text into share preferences
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        //Define the SharedPreferences.Editor
        var editor = sharedPreferences.edit()

        editor.putString("name", enteredText)

        editor.commit()
    }
}