package koin.example.snapnoob.insertkoin.util.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import koin.example.snapnoob.insertkoin.R

internal fun FragmentManager.removeFragment(tag: String,
                                            slidIn: Int = R.anim.slide_left,
                                            slidOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slidIn, slidOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         slidIn: Int = R.anim.slide_left,
                                         slidOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slidIn, slidOut)
            .add(containerViewId, fragment, tag)
            .commit()
}