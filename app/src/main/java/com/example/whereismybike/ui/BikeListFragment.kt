package com.example.whereismybike.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.whereismybike.databinding.BikeAddressListFragmentBinding
import com.example.whereismybike.model.Bike
import com.example.whereismybike.ui.adapter.BikeListAdapter
import com.example.whereismybike.ui.viewmodel.BikeAddressListViewModel

private const val TAG = "BikeAddressListFragment"
class BikeAddressListFragment : Fragment() {

    private lateinit var bikeAddresses: List<Bike>

    private val viewModel: BikeAddressListViewModel by activityViewModels()

    private var _binding: BikeAddressListFragmentBinding? = null

    // can only use between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bikeAddresses = viewModel.bikes.value!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView" )

        _binding = BikeAddressListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated" )
        val adapter = BikeListAdapter(bikeAddresses)
        binding.recycleView.adapter = adapter;
        viewModel.bikes.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }

        binding.addBtn.setOnClickListener {
            viewModel.addBikeAddress()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.addBike
        Address()
        Log.d(TAG, "Fragment OnStart" )
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "Fragment OnStop" )
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "Fragment OnResume" )
    }
}