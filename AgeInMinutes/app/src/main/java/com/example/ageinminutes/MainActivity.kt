package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
            Toast.makeText(this, "Button Works", Toast.LENGTH_LONG).show()
        }
    }

    fun clickDatePicker(View: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

       val dpd =  DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { view, selectedYear, selectedMonth, selectedDayOfMonth ->
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            tvSelectedDate.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate: Date = sdf.parse(selectedDate)
            val selectedDateInMinutes = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateToMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
            tvSelectedDateInMinutes.text = differenceInMinutes.toString()
        }, year, month, dayOfMonth
       )
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}
