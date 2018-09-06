package koin.example.snapnoob.insertkoin.ui.main.view

import koin.example.snapnoob.insertkoin.data.network.MovieData
import koin.example.snapnoob.insertkoin.ui.base.view.BaseViewContract

interface MainActivityContract : BaseViewContract {

    fun displayNowPlayingMovie(movie: List<MovieData>?)

    fun displayUpcomingMovie(movie: List<MovieData>?)
}