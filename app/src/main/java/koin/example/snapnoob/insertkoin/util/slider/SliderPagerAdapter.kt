package koin.example.snapnoob.insertkoin.util.slider

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class SliderPagerAdapter(fm: FragmentManager, private val fragments: List<Fragment>) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment? {
        val index = position % fragments.size
        return fragments[index].arguments?.getString("params")?.let { FragmentSlider.newInstance(it) }
    }

    override fun getCount(): Int = fragments.size
}