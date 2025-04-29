package com.example.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.switchmaterial.SwitchMaterial
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.text.InputType
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import androidx.core.net.toUri

class HomeFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Find the views
        val switch  = view.findViewById<SwitchMaterial>(R.id.switchHome)
        val seekBar = view.findViewById<SeekBar>(R.id.seekBarHome)
        val textView = view.findViewById<TextView>(R.id.textViewHome)
        val vumfinder = view.findViewById<Button>(R.id.btnVumFinder)

        // 1.1) Set dynamic initial state
        textView.text = "Progress: ${seekBar.progress}"
        vumfinder.setEnabled(switch.isChecked)

        // 2) Listen for switch toggles
        switch.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(
                requireContext(),
                "Feature ${if (isChecked) "Enabled" else "Disabled"}",
                Toast.LENGTH_SHORT
            ).show()
            vumfinder.setEnabled(isChecked)
        }

        // 3) Listen for seekbar changes
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Optional: highlight thumb, etc.
            }
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = "Progress: ${progress}"
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Optional: finalize value
            }
        })

        // 4) Single-choice dialog (3 options)
        val btnSingle = view.findViewById<Button>(R.id.btnSingleChoice)
        btnSingle.setOnClickListener {
            val options = arrayOf("Option A", "Option B", "Option C")
            var selectedIndex = -1

            AlertDialog.Builder(requireContext())
                .setTitle("Pick an option")
                .setSingleChoiceItems(options, -1) { _, which ->
                    selectedIndex = which
                }
                .setPositiveButton("OK") { _, _ ->
                    if (selectedIndex >= 0) {
                        Toast.makeText(
                            requireContext(),
                            "You chose: ${options[selectedIndex]}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

// 5) Input dialog
        val btnInput = view.findViewById<Button>(R.id.btnInputDialog)
        btnInput.setOnClickListener {
            val input = EditText(requireContext()).apply {
                hint = "Your name"
                inputType = InputType.TYPE_CLASS_TEXT
            }

            AlertDialog.Builder(requireContext())
                .setTitle("Enter your name")
                .setView(input)
                .setPositiveButton("Submit") { _, _ ->
                    val name = input.text.toString().trim()
                    if (name.isNotEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Hello, $name!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        // 6) Launch Maps with predefined coordinates/place
        vumfinder.setOnClickListener {
            val coords = "43.21213216922771, 27.909251722787033"
            val label  = "Varna University of Management"
            val geoUri = "geo:$coords?q=$coords($label)".toUri()

            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri).apply {
                setPackage("com.google.android.apps.maps")
            }

            // Verify there’s an app to handle this Intent
            if (mapIntent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(
                    requireContext(),
                    "No application with maps found, can't show where VUM is!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}