package com.example.virginmobiletest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmobiletest.databinding.ItemRoomsBinding
import com.example.virginmobiletest.dataresponse.Rooms

class RoomsRecyclerAdapter(private val mList: ArrayList<Rooms>) : RecyclerView.Adapter<RoomsRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemRoomsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = if (mList[position].isOccupied) {
            "Occupied"
        } else {
            "Empty"
        }

        holder.binding.textTitleRooms.text = "Room number "+ mList[position].id + " is " +result
}
    override fun getItemCount(): Int {
        return mList.size
    }

    fun addItems(arrayList: ArrayList<Rooms>) {
        mList.addAll(arrayList)
        notifyDataSetChanged()

    }

    class ViewHolder(val binding: ItemRoomsBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}