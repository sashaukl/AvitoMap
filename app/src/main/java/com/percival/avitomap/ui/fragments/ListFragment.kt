package com.percival.avitomap.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.percival.avitomap.R
import com.percival.avitomap.ui.adapters.ServiceAdapter
import com.percival.avitomap.ui.viewmodels.SharedViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: ServiceAdapter

    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recycler = view.services_recycler
        initRecyclerView()
        return view
    }


    private fun initRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(context)
        adapter = ServiceAdapter{ str -> sharedViewModel.changeActiveServices(str)}
        recycler.layoutManager = linearLayoutManager
        adapter.updateList( sharedViewModel.pinMap.value?.keys?.toList(), sharedViewModel.activeServices.value )
        recycler.adapter = adapter
        sharedViewModel.pinMap.observe(this, Observer {
            adapter.updateList(it.keys.toList(), sharedViewModel.activeServices.value)
        })

    }

}
