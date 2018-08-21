package koin.example.snapnoob.insertkoin.data

import io.reactivex.Single
import koin.example.snapnoob.insertkoin.data.network.AppApiHelper
import koin.example.snapnoob.insertkoin.data.network.MovieResponse
import koin.example.snapnoob.insertkoin.data.preferences.AppPreferenceHelper
import koin.example.snapnoob.insertkoin.util.AppConstants

class AppDataManager(private val appPreferenceHelper: AppPreferenceHelper, private val appApiHelper: AppApiHelper) : DataManager {


    override fun performNowPlayingMovie(): Single<MovieResponse> = appApiHelper.performNowPlayingMovie()

    override fun performUpcomingMovie(): Single<MovieResponse> = appApiHelper.performUpcomingMovie()

    override fun performSearchMovieData(query: String): Single<MovieResponse> = appApiHelper.performSearchMovieData(query)


    override fun getCurrentUserLoggedInMode(): Int = appPreferenceHelper.getCurrentUserLoggedInMode()

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        appPreferenceHelper.setCurrentUserLoggedInMode(mode)
    }

    override fun getCurrentUserId(): Long? = appPreferenceHelper.getCurrentUserId()

    override fun setCurrentUserId(userId: Long?) {
        appPreferenceHelper.setCurrentUserId(userId)
    }

    override fun getCurrentUserName(): String? = appPreferenceHelper.getCurrentUserName()

    override fun setCurrentUserName(userName: String?) {
        appPreferenceHelper.setCurrentUserName(userName)
    }

    override fun getCurrentUserEmail(): String? = appPreferenceHelper.getCurrentUserEmail()

    override fun setCurrentUserEmail(userEmail: String?) {
        appPreferenceHelper.setCurrentUserEmail(userEmail)
    }

    override fun getAccessToken(): String? = appPreferenceHelper.getAccessToken()

    override fun setAccessToken(accessToken: String?) {
        appPreferenceHelper.setAccessToken(accessToken)
    }
}