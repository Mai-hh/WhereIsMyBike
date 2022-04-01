package com.example.whereismybike.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.whereismybike.BaseApplication
import com.example.whereismybike.databinding.BikeListFragmentBinding
import com.example.whereismybike.ui.adapter.BikeListAdapter
import com.example.whereismybike.ui.viewmodel.BikeListViewModel
import com.example.whereismybike.ui.viewmodel.BikeListViewModelFactory

private const val TAG = "BikeAddressListFragment"
class BikeListFragment : Fragment() {

    private val viewModel: BikeListViewModel by activityViewModels {
        BikeListViewModelFactory(
            (activity?.application as BaseApplication).database.bikeDao
        )
    }

    private var _binding: BikeListFragmentBinding? = null

    // can only use between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d(TAG, "onCreateView" )
        _binding = BikeListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated" )

        val adapter = BikeListAdapter(viewModel.bikes.value)
        viewModel.bikes.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }

        binding.apply {
            recycleView.adapter = adapter
            addBtn.setOnClickListener {
                viewModel.addBikeAddress()
            }
        }
    }
}