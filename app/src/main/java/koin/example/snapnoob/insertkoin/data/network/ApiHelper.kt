package koin.example.snapnoob.insertkoin.data.network

import io.reactivex.Single

interface ApiHelper {

    fun performNowPlayingMovie(): Single<MovieResponse>

    fun performUpcomingMovie(): Single<MovieResponse>

    fun performSearchMovieData(query: String): Single<MovieResponse>

}