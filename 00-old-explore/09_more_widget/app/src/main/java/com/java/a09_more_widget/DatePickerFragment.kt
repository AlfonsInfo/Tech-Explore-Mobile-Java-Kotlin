package com.java.a09_more_widget

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*





//constructor dipanggil langsung saat extends
class  DatePickerFragment : DialogFragment() , DatePickerDialog.OnDateSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()

        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DATE)
        return DatePickerDialog(
            requireContext(), this, year, month, day
        )
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(requireContext(),"Date : ${dayOfMonth} - ${month} - ${year}", Toast.LENGTH_SHORT).show()
    }
}
