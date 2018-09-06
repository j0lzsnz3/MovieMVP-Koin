package koin.example.snapnoob.insertkoin.data.network

import koin.example.snapnoob.insertkoin.BuildConfig

object ApiEndPoint {
    val ENDPOINT_MOVIE_API_KEY = BuildConfig.MOVIE_API_KEY
    val ENDPOINT_MOVIES_NOWPLAYING = BuildConfig.MOVIE_BASE_URL + "now_playing?language=en-US"
    val ENDPOINT_MOVIES_UPCOMING = BuildConfig.MOVIE_BASE_URL + "upcoming?language=en-US"
    val ENDPOINT_MOVIES_SEARCH = BuildConfig.MOVIE_URL_SEARCH + "movie?language=en-US"

}