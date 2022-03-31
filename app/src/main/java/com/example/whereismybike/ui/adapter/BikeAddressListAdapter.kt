package com.example.whereismybike.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.whereismybike.databinding.BikeAddressListFragmentBinding
import com.example.whereismybike.databinding.ListItemBikeAddressLayoutBinding
import com.example.whereismybike.model.BikeAddress
import com.example.whereismybike.ui.viewmodel.BikeAddressListViewModel

class BikeAddressListAdapter(
    private var bikeAddresses: List<BikeAddress>
) : RecyclerView.Adapter<BikeAddressListAdapter.BikeAddressViewHolder>() {

    class BikeAddressViewHolder(val binding: ListItemBikeAddressLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeAddressViewHolder {
        return BikeAddressViewHolder(
            ListItemBikeAddressLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BikeAddressViewHolder, position: Int) {
        val address = bikeAddresses[position]
        holder.binding.apply {
            bikeAddressText.text = address.tick
        }
    }

    override fun getItemCount(): Int {
        return bikeAddresses.size
    }

    fun setList(newList: List<BikeAddress>) {
        bikeAddresses = newList
        notifyDataSetChanged()
    }

}