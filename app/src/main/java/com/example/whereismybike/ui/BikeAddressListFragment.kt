package com.example.whereismybike.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.whereismybike.R
import com.example.whereismybike.TestFile
import com.example.whereismybike.databinding.BikeAddressListFragmentBinding
import com.example.whereismybike.model.BikeAddress
import com.example.whereismybike.ui.adapter.BikeAddressListAdapter
import com.example.whereismybike.ui.viewmodel.BikeAddressListViewModel

private const val TAG = "BikeAddressListFragment"
class BikeAddressListFragment : Fragment() {

    private lateinit var bikeAddresses: List<BikeAddress>

    private val viewModel: BikeAddressListViewModel by activityViewModels()

    private var _binding: BikeAddressListFragmentBinding? = null

    // can only use between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bikeAddresses = viewModel.bikeAddresses.value!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BikeAddressListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated" )
        val adapter = BikeAddressListAdapter(bikeAddresses)
        binding.recycleView.adapter = adapter;
        viewModel.bikeAddresses.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }

        binding.addBtn.setOnClickListener {
            viewModel.addBikeAddress()
            Log.d(TAG, "add" )
        }
    }
}