package koin.example.snapnoob.insertkoin.util.slider

import android.content.Context
import android.support.v4.view.ViewPager
import android.widget.LinearLayout

class SliderIndicator(context: Context, containerView: LinearLayout, viewPager: ViewPager, drawableResr: Int) : ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {
}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initIndicator(){

    }

    private fun setIndicatorAsSelected(){

    }
}