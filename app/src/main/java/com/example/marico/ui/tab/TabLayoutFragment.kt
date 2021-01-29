package com.example.marico.ui.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.marico.R
import com.google.android.material.tabs.TabLayout

class TabLayoutFragment : Fragment() {

    private lateinit var tabLayoutViewModel: TabLayoutViewModel
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tabLayoutViewModel =
                ViewModelProvider(this).get(TabLayoutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tab_layout, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        tabLayoutViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        tabLayout = root.findViewById<TabLayout>(R.id.tabLayout)
        viewPager = root.findViewById<ViewPager>(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Webview"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Image"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = context?.let { fragmentManager?.let { it1 ->
            MyAdapter(it,
                it1, tabLayout!!.tabCount)
        } }
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return root
    }
}