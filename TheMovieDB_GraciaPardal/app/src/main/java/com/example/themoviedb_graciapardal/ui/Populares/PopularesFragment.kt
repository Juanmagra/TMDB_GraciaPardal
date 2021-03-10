package com.example.themoviedb_graciapardal.ui.Populares

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb_graciapardal.R
import com.example.themoviedb_graciapardal.poko.People

class PopularesFragment : Fragment() {


    var listaPeople: List<People> = listOf()
    lateinit var listaAdapter: MyPopularRecyclerViewAdapter
    private lateinit var viewModel: PopularesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_people_list, container, false)

        viewModel = ViewModelProvider(this).get(PopularesViewModel::class.java)

        val v = view as RecyclerView

        listaAdapter = MyPopularRecyclerViewAdapter(listaPeople)
        v.layoutManager = LinearLayoutManager(context)
        v.adapter = listaAdapter

        viewModel.people.observe(viewLifecycleOwner, Observer {
                people -> listaPeople = people
            listaAdapter.setData(people.sortedWith(compareBy({ it.name })))
        })
        return  view
    }
}