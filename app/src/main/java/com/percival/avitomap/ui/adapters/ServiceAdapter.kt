package com.percival.avitomap.ui.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.percival.avitomap.R
import kotlinx.android.synthetic.main.cell_service.view.*

class ServiceAdapter(val callback: (String) -> Unit): RecyclerView.Adapter<ServiceAdapter.ViewHolder>(){

    var list: List<String> = ArrayList()
    var activeServicesSet = HashSet<String>()

    fun updateList(newList: List<String>?, set: Set<String>?){
        list = newList ?: ArrayList()
        activeServicesSet = set?.toHashSet() ?: HashSet()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_service, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], callback, activeServicesSet)
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){
        private val serviceNameView: TextView = view.service_name
        private val checkImage: ImageView = view.check

        fun bind(serviceName: String, clickListener: (String) -> Unit, activeServicesSet: MutableSet<String>) {
            serviceNameView.text = serviceName
            view.setOnClickListener {
                clickListener(serviceName)
                checkSelection(serviceName, activeServicesSet)
            }
            checkImage.visibility = if(activeServicesSet.contains(serviceName)) View.VISIBLE; else View.GONE
        }

        private fun checkSelection(serviceName: String, activeServicesSet: MutableSet<String>){
            if (activeServicesSet.contains(serviceName)) {
                activeServicesSet.remove(serviceName)
                checkImage.visibility = View.GONE
            } else {
                activeServicesSet.add(serviceName)
                checkImage.visibility = View.VISIBLE
            }
        }


    }
}