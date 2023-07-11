package com.example.ejercicioindividual34.Ui.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual34.Domain.Model.Mars
import com.example.ejercicioindividual34.R
import com.example.ejercicioindividual34.Ui.ViewModel.MarsViewModel

class MarsAdapter(
    private var marsRealStates: List<Mars>
    ): RecyclerView.Adapter<MarsRealStateViewHolder>() {

    private var onItemClickListener: ((Mars) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsRealStateViewHolder {
       val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return MarsRealStateViewHolder(layoutInflater.inflate(R.layout.item_grid, parent, false))
    }

    override fun onBindViewHolder(holder: MarsRealStateViewHolder, position: Int) {
        val marsRealState = marsRealStates[position]
        holder.bind(marsRealState)

        holder.itemView.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(marsRealState.id)
            it.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int = marsRealStates.size

    fun updateData(marsRealStates: List<Mars>) {
        this.marsRealStates = marsRealStates
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Mars) -> Unit) {
        onItemClickListener = listener
    }

}
