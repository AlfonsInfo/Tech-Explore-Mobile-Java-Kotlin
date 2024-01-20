package com.java.a09_more_widget

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*
import com.java.a09_more_widget.TimePickerListener




//constructor dipanggil langsung saat extends
class  TimePickerFragment : DialogFragment() , TimePickerDialog.OnTimeSetListener {
    private lateinit var listener: TimePickerListener

    fun setTimePickerListener(listener: TimePickerListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val c : Calendar = Calendar.getInstance()
       var hour = c.get(Calendar.HOUR_OF_DAY)
       var minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(
            activity,
            this,
            hour,
            minute,
        true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(activity,"Time Picker Successfully", Toast.LENGTH_SHORT).show()
        listener.onTimeSelected(hourOfDay,minute)
        //sendResult(1,"${hourOfDay}:${minute}")
    }

    private fun sendResult(resultCode: Int, mDate: String) {
        if (targetFragment == null) return
        val i = Intent()
        i.putExtra("EXTRA_DATE", mDate)
        targetFragment!!.onActivityResult(targetRequestCode, resultCode, i)
    }

}
