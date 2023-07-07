package com.example.ejercicioindividual34.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual34.Model.MarsRealState
import com.example.ejercicioindividual34.ViewModel.MarsViewModel
import com.example.ejercicioindividual34.databinding.FragmentFirstBinding


class FirstFragment : Fragment(){

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var marsViewModel: MarsViewModel
    private lateinit var marsAdapter: MarsAdapter
    private var marsRealStatesList: List<MarsRealState> = mutableListOf()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recycler
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        marsAdapter = MarsAdapter(marsRealStatesList)
        recyclerView.adapter = marsAdapter

        marsViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)
        fetchDataFromAPI()
    }

    private fun fetchDataFromAPI() {
        marsViewModel.liveDatafromInternet.observe(viewLifecycleOwner) { marsRealStates ->
            marsAdapter.updateData(marsRealStates)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}