package com.example.virginmobiletest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmobiletest.BaseApplication
import com.example.virginmobiletest.adapter.PeopleRecyclerAdapter
import com.example.virginmobiletest.adapter.RoomsRecyclerAdapter
import com.example.virginmobiletest.databinding.RoomsFragmentBinding
import com.example.virginmobiletest.dataresponse.People
import com.example.virginmobiletest.dataresponse.Rooms
import com.example.virginmobiletest.repository.*

class RoomsFragment : Fragment() {
    private lateinit var binding: RoomsFragmentBinding
    private lateinit var viewModel: RoomsViewModel
    private val apiService = BaseApplication.getApiInterface()
    private var list: ArrayList<Rooms>? = null
    val data = ArrayList<Rooms>()
    var adapter = RoomsRecyclerAdapter(data)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RoomsFragmentBinding.inflate(inflater, container, false)

        binding.listRooms.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL,false)

        viewModel = ViewModelProvider(
            this,
            RoomsViewModelFactory(ApiRepository(apiService))
        ).get(RoomsViewModel::class.java)

        viewModel.getRoomsInfo()

        activity?.let {
            viewModel.roomsList.observe(it, Observer {
                list = it as ArrayList<Rooms>
                adapter?.addItems(list as ArrayList<Rooms>)
                binding.listRooms.adapter = adapter
            })
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}