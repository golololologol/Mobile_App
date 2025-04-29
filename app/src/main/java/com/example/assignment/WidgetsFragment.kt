package com.example.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast

class WidgetsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_widgets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Spinner setup
        val spinner = view.findViewById<Spinner>(R.id.spinnerWidgets)
        val items     = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        val adapter   = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            items
        ).also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    requireContext(),
                    "Selected: ${items[position]}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // No action
            }
        }  //

        // 2) DatePicker setup
        val datePicker = view.findViewById<DatePicker>(R.id.datePickerWidgets)
        // Initialize listener with current date
        val year  = datePicker.year
        val month = datePicker.month
        val day   = datePicker.dayOfMonth

        datePicker.init(year, month, day) { _, y, m, d ->
            Toast.makeText(
                requireContext(),
                "Picked: ${d}/${m + 1}/$y",
                Toast.LENGTH_SHORT
            ).show()
        }  //
    }
}