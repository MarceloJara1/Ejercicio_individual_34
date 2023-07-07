package com.example.ejercicioindividual34.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual34.Model.MarsRealState
import com.example.ejercicioindividual34.R

class MarsAdapter(private var marsRealStates: List<MarsRealState>): RecyclerView.Adapter<MarsRealStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsRealStateViewHolder {
       val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return MarsRealStateViewHolder(layoutInflater.inflate(R.layout.item_grid, parent, false))
    }

    override fun onBindViewHolder(holder: MarsRealStateViewHolder, position: Int) {
        val marsRealState = marsRealStates[position]
        holder.bind(marsRealState)

    }

    override fun getItemCount(): Int = marsRealStates.size

    fun updateData(marsRealStates: List<MarsRealState>) {
        this.marsRealStates = marsRealStates
        notifyDataSetChanged()
    }

}
