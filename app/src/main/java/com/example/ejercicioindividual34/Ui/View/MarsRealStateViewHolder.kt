package com.example.ejercicioindividual34.Ui.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicioindividual34.Domain.Model.Mars
import com.example.ejercicioindividual34.databinding.ItemGridBinding

class MarsRealStateViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemGridBinding.bind(view)

    fun bind(marsRealState: Mars) {

        Glide.with(binding.img.context).load(marsRealState.img).into(binding.img)
    }
}