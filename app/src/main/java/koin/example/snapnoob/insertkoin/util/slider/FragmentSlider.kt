package koin.example.snapnoob.insertkoin.util.slider

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.util.ext.loadImageMovie
import kotlinx.android.synthetic.main.fragment_movie_discover.*

class FragmentSlider : Fragment() {

    private var imgUrl: String? = null

    companion object {

        private val ARG_PARAM1 = "params"

        fun newInstance(params: String): FragmentSlider {
            val fragment = FragmentSlider()
            val args = Bundle()
            args.putString(ARG_PARAM1, params)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.let { imgUrl = it.getString(ARG_PARAM1) }
        imgUrl?.let { imgMovieDiscover.loadImageMovie(it) }
        return inflater.inflate(R.layout.fragment_movie_discover, container, false)
    }
}