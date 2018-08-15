package koin.example.snapnoob.insertkoin.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class AppApiHelper : ApiHelper {

    override fun performNowPlayingMovie(): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_NOWPLAYING)
                    .addQueryParameter("api_key", ApiEndPoint.ENDPOINT_MOVIE_API_KEY)
                    .build()
                    .getObjectSingle(MovieResponse::class.java)

    override fun performUpcomingMovie(): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_UPCOMING)
                    .addQueryParameter("api_key", ApiEndPoint.ENDPOINT_MOVIE_API_KEY)
                    .build()
                    .getObjectSingle(MovieResponse::class.java)

    override fun performSearchMovieData(query: String): Single<MovieResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_SEARCH)
                    .addQueryParameter("api_key", ApiEndPoint.ENDPOINT_MOVIE_API_KEY)
                    .addQueryParameter("query", query)
                    .build()
                    .getObjectSingle(MovieResponse::class.java)

}