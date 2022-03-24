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
import com.example.virginmobiletest.databinding.PeopleFragmentBinding
import com.example.virginmobiletest.dataresponse.People
import com.example.virginmobiletest.repository.ApiRepository
import com.example.virginmobiletest.repository.MainViewModel
import com.example.virginmobiletest.repository.MyViewModelFactory

class PeopleFragment : Fragment() {
    private lateinit var binding: PeopleFragmentBinding
    private lateinit var viewModel: MainViewModel
    private val apiService = BaseApplication.getApiInterface()
    private var list: ArrayList<People>? = null
    val data = ArrayList<People>()

   var adapter = PeopleRecyclerAdapter(data)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PeopleFragmentBinding.inflate(inflater, container, false)

        binding.listPeoples.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(ApiRepository(apiService))
        ).get(MainViewModel::class.java)

        viewModel.getPeopleInfo()

        activity?.let {
            viewModel.peopleList.observe(it, Observer {
                list = it as ArrayList<People>
                adapter?.addItems(list as ArrayList<People>)
                binding.listPeoples.adapter = adapter
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