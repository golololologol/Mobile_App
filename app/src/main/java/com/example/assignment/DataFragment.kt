package com.example.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader

class DataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Find RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 2) Read lines from assets/data.txt
        val itemList = mutableListOf<DataItem>()
        requireContext().assets.open("data.txt").use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).forEachLine { line ->
                itemList.add(DataItem(line))
            }
        }

        // 3) Set adapter with the loaded data
        val adapter = DataAdapter(itemList)
        recyclerView.adapter = adapter
    }
}