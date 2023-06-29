package com.java.a09_more_widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private lateinit var box1 : CheckBox
    private lateinit var box2 : CheckBox
    private lateinit var btn : Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var spinner : Spinner
    private lateinit var timePicker: TimePicker


    //Initialize
    private fun initializeWidget(){
        box1 = findViewById(R.id.checkbox_cheese)
        box2 = findViewById(R.id.checkbox_box2)
        btn = findViewById(R.id.btnGetValue)
        radioGroup = findViewById(R.id.rgroupDelivery)
        timePicker = findViewById(R.id.time_picker)
        timePicker.is24HourView
        initializeSpinner()
    }

    private fun initializeSpinner() {
        spinner = findViewById(R.id.language_spinner)
        val courses = arrayOf<String>("C++","Android Development", "Full Stack Web", "Data Structures")
        // ArrayAdapter(context, resource , object).set..()
        val ad = ArrayAdapter(this, android.R.layout.simple_spinner_item,courses)
        ad.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        spinner.setAdapter(ad)
    }


    //ACTION
    private fun actionCheckedBox(){
        if(box1.isChecked){
            Toast.makeText(this, "Cheese Topping is Added", Toast.LENGTH_SHORT).show()
        }else{

        }

        if(box2.isChecked){
            Toast.makeText(this, "Box2 is Added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun actionRadionButton(){
        //Radio
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            var radioBtn : RadioButton = findViewById(checkedId)
            Toast.makeText(this, "Selected : " + radioBtn.text, Toast.LENGTH_SHORT ).show()
        }
    }

    private fun actionSpinner(){
        //Spinner / Drop Down
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                val message = "Selected Item: $selectedItem"
                Toast.makeText(this@MainActivity ,message  , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun actionTimePicker(){
//        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            var selectedTime = "Time = ${timePicker.currentHour} : ${timePicker.currentMinute}"
            Toast.makeText(this, selectedTime,Toast.LENGTH_SHORT).show()
//        }
    }

    //OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeWidget()
        btn.setOnClickListener {
            actionCheckedBox()
            actionRadionButton()
            actionSpinner()
            actionTimePicker()
        }

    }
}