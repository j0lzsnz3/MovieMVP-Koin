package koin.example.snapnoob.insertkoin.ui.detailMovie.presenter

import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenterContract
import koin.example.snapnoob.insertkoin.ui.detailMovie.view.DetailActivityContract

interface DetailPresenterContract<V: DetailActivityContract> : BasePresenterContract<V> {

    fun loadMovieDetail(query: String)

}