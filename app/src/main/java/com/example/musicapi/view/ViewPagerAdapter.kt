package com.example.musicapi.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                RockDisplayFragment()
            }
            1 -> {
                ClassicDisplayFragment()
            }
            2 -> {
                PopDisplayFragment()
            }
            else -> getItem(position)
        }

    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)

        var title: String? = null
        if (position == 0) title = "Rock"
        else if (position == 1) title = "Classic"
        else if (position == 2) title = "Pop"
        return title
    }
}