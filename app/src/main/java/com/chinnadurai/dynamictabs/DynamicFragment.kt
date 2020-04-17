package com.chinnadurai.dynamictabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dynamic.view.*

class DynamicFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dynamic, container, false)
        view.textName?.text = "Fragment - ${arguments!!.getInt("someInt", 0)}"
        return view
    }

    companion object {
        fun addFragment(position: Int): DynamicFragment {
            val fragment = DynamicFragment()
            val args = Bundle()
            args.putInt("someInt", position)
            fragment.arguments = args
            return fragment
        }
    }
}