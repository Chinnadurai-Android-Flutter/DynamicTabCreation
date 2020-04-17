package com.chinnadurai.dynamictabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinnadurai.dynamictabs.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (k in 0..9) {
            tabLayout.addTab(tabLayout.newTab().setText("" + k))
        }
        val adapter = TabAdapter(supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter
        viewPager!!.offscreenPageLimit = 1
        viewPager!!.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
    }
}