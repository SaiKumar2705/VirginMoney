package com.example.virginmobiletest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.virginmobiletest.databinding.ActivityMainBinding
import com.example.virginmobiletest.fragment.PeopleFragment
import com.example.virginmobiletest.fragment.RoomsFragment

class FragmentAdapter(
    var context: ActivityMainBinding,
    fm: FragmentManager,
    var totalTabs: Int
    ) :
    FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    PeopleFragment()
                }
                1 -> {
                    RoomsFragment()
                }

                else -> getItem(position)
            }
        }
        override fun getCount(): Int {
            return totalTabs
        }
}