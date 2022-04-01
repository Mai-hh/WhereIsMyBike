package com.example.whereismybike.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whereismybike.databinding.ListItemBikeAddressLayoutBinding
import com.example.whereismybike.model.Bike

class BikeListAdapter(
    private var bikeAddresses: List<Bike>
) : RecyclerView.Adapter<BikeListAdapter.BikeAddressViewHolder>() {

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
            bikeAddressText.text = address.dateTime
        }
    }

    override fun getItemCount(): Int {
        return bikeAddresses.size
    }

    fun setList(newList: List<Bike>) {
        bikeAddresses = newList
        notifyDataSetChanged()
    }

}