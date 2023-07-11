package com.example.ejercicioindividual34.Ui.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual34.Data.Model.MarsModel
import com.example.ejercicioindividual34.Domain.Model.Mars
import com.example.ejercicioindividual34.R
import com.example.ejercicioindividual34.Ui.ViewModel.MarsViewModel
import com.example.ejercicioindividual34.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(){

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var marsViewModel: MarsViewModel
    private lateinit var marsAdapter: MarsAdapter
    private var marsRealStatesList: List<Mars> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        marsViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)
        marsAdapter = MarsAdapter(marsRealStatesList)

        recyclerView = binding.recycler
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        recyclerView.adapter = marsAdapter

        marsViewModel.marsList.observe(viewLifecycleOwner) { marsList ->
            if (marsList != null) {
                marsAdapter.updateData(marsList)
            }
        }
        marsViewModel.onCreate()

        marsAdapter.setOnItemClickListener { mars ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(id = mars.id)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}