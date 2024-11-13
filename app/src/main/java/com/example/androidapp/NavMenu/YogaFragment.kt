package com.example.androidapp.NavMenu

import ItemAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.Item
import com.example.androidapp.R


class YogaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_yoga, container, false)

        // Sample data
        val items = listOf(
            Item(R.drawable.yoga1, "Title 1", "Description 1"),
            Item(R.drawable.yoga2, "Title 2", "Description 2"),
            Item(R.drawable.yoga3, "Title 3", "Description 3"),
            Item(R.drawable.yoga4, "Title 4", "Description 4"),
            Item(R.drawable.yoga5, "Title 5", "Description 5")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ItemAdapter(items)

        return view
    }

}