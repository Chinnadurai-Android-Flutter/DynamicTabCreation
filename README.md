# Dynamic-Tabs-Android
#
## 1.In your activity_main.xml make TabLayout
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:minHeight="?actionBarSize"
        app:tabGravity="fill"
        app:tabMode="fixed"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:background="#1db995">
    </com.google.android.material.tabs.TabLayout>

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </androidx.viewpager.widget.ViewPager>
    
    </androidx.constraintlayout.widget.ConstraintLayout>

#
#### 2. In your MainActivity find views for TabLayout and make some adjustments for producing dynamic tabs

             for (k in 0..9) {
                       tabLayout.addTab(tabLayout.newTab().setText("" + k))
                   }
                   val adapter = TabAdapter(supportFragmentManager, tabLayout!!.tabCount)
                   viewPager!!.adapter = adapter
                   viewPager!!.offscreenPageLimit = 1
                   viewPager!!.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

#
### Note : From the above code, this for() loop is the key to achieving where we are performing dynamic fragments and attaching them to tab design you can make as many dynamic fragments as you require.

        for (k in 0..9) {
                               tabLayout.addTab(tabLayout.newTab().setText("" + k))
                           }
                
#
#### 3. Now we need some binding mechanism which can give our dynamically produced fragments on to the UI, here I am using a simple Fragment by the name of DynamicFragment and its addFragment() method. From our TabAdapter, I am using getItem() method to pass the position of the dynamically generated fragment and we can get this position easily in the onCreateView() of our fragment


class TabAdapter(fm: FragmentManager?, var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return DynamicFragment.addFragment(position)
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

}
        
#
#### 4.Get the position of fragments and show it in the Dynamically generated fragment


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


#### Output 😍 :
<img src="https://github.com/Chinnadurai-Android-Flutter/DynamicTabCreation/blob/master/screenshot-1587101578965.jpg" width="270" height="480">
