package com.chinnadurai.dynamictabs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.chinnadurai.dynamictabs.DynamicFragment

class TabAdapter(fm: FragmentManager?, var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return DynamicFragment.addFragment(position)
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

}