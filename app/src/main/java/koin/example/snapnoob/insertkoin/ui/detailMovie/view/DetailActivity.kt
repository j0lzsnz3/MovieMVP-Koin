package koin.example.snapnoob.insertkoin.ui.detailMovie.view

import android.os.Bundle
import android.util.Log
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.data.network.MovieData
import koin.example.snapnoob.insertkoin.ui.base.view.BaseActivity
import koin.example.snapnoob.insertkoin.ui.detailMovie.presenter.DetailPresenterContract
import koin.example.snapnoob.insertkoin.ui.main.view.MainActivity
import koin.example.snapnoob.insertkoin.util.ext.loadImageMovie
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity(), DetailActivityContract {

    private val detailPresenter: DetailPresenterContract<DetailActivityContract> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        loadMovieDetail()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDettached(tag: String) {
    }

    private fun loadMovieDetail(){
        val imgMovieUrl = intent.getStringExtra(intentImgUrl)
        val titleMovie = intent.getStringExtra(intentTitle)
        val descMovie = intent.getStringExtra(intentDesc)

        imgDetailMovie.loadImageMovie(imgMovieUrl)
        tvTitle.text = titleMovie
        tvDesc.text = descMovie
    }

    companion object {
        const val intentImgUrl = "IMG_URL"
        const val intentTitle = "TITLE"
        const val intentDesc = "DESC"

    }

}
