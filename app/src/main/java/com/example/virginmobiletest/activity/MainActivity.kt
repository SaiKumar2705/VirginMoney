package com.example.virginmobiletest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.virginmobiletest.R
import com.example.virginmobiletest.adapter.FragmentAdapter
import com.example.virginmobiletest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.people_fragment)))
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.rooms_fragment)))
            tabLayout.tabGravity = TabLayout.GRAVITY_FILL
            val adapter = FragmentAdapter(
                this, supportFragmentManager,
                tabLayout.tabCount
            )
            viewPager.adapter = adapter
            viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }

}