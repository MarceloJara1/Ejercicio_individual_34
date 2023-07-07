package com.example.ejercicioindividual34.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicioindividual34.Model.MarsRealState
import com.example.ejercicioindividual34.databinding.ItemGridBinding

class MarsRealStateViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemGridBinding.bind(view)

    fun bind(marsRealState: MarsRealState) {

        Glide.with(binding.img.context).load(marsRealState.img).into(binding.img)
    }
}