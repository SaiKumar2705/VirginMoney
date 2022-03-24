package com.example.virginmobiletest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmobiletest.databinding.ItemPeopleBinding
import com.example.virginmobiletest.dataresponse.People

class PeopleRecyclerAdapter(private val mList: ArrayList<People>) : RecyclerView.Adapter<PeopleRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.textTitle.text = mList[position].firstName
}
    override fun getItemCount(): Int {
        return mList.size
    }

    fun addItems(arrayList: ArrayList<People>) {
        mList.addAll(arrayList)
        notifyDataSetChanged()

    }

    class ViewHolder(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}