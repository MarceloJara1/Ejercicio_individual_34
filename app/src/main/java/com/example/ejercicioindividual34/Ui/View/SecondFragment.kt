package com.example.ejercicioindividual34.Ui.View

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ejercicioindividual34.Data.Repository
import com.example.ejercicioindividual34.Ui.ViewModel.MarsViewModel
import com.example.ejercicioindividual34.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private lateinit var marsViewModel: MarsViewModel
    private val TAG = "SecondFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        marsViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)

        val marsId = SecondFragmentArgs.fromBundle(requireArguments()).id
        Log.d(TAG, "MARS ID $marsId")


        marsViewModel.marsList.observe(viewLifecycleOwner) { marsList ->
            val selectedMars = marsList?.find { mars -> mars.id == marsId }
            selectedMars?.let { mars ->

                Glide.with(binding.img.context).load(mars.img).into(binding.img)
                binding.txtPrice.text = mars.price.toString()
                binding.txtType.text = mars.type
            }
        }
        marsViewModel.onCreate()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}