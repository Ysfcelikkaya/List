package com.yusufcelikkaya.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView

    private val itemList = mutableListOf<Item>()
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)


        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        addButton = view.findViewById(R.id.addButton)
        recyclerView = view.findViewById(R.id.recyclerView)


        adapter = ToDoAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        addButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty()) {

                val newItem = Item(title, description)


                itemList.add(newItem)


                adapter.notifyDataSetChanged()


                titleEditText.text.clear()
                descriptionEditText.text.clear()


                Toast.makeText(requireContext(), "Item added successfully", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
