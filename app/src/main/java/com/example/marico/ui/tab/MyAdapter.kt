package com.example.marico.ui.tab

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.marico.ui.home.HomeFragment
import com.example.marico.ui.image.CaptureImageFragment
import com.example.marico.ui.webview.WebviewFragment

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return WebviewFragment()
            }
            1 -> {
                return CaptureImageFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return HomeFragment()
            }
            else -> return HomeFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}