package com.example.ejercicioindividual34.Ui.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual34.Domain.Model.Mars
import com.example.ejercicioindividual34.R

class MarsAdapter(private var marsRealStates: List<Mars>): RecyclerView.Adapter<MarsRealStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsRealStateViewHolder {
       val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return MarsRealStateViewHolder(layoutInflater.inflate(R.layout.item_grid, parent, false))
    }

    override fun onBindViewHolder(holder: MarsRealStateViewHolder, position: Int) {
        val marsRealState = marsRealStates[position]
        holder.bind(marsRealState)

    }

    override fun getItemCount(): Int = marsRealStates.size

    fun updateData(marsRealStates: List<Mars>) {
        this.marsRealStates = marsRealStates
        notifyDataSetChanged()
    }

}
