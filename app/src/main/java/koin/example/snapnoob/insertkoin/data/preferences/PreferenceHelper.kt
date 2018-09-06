package koin.example.snapnoob.insertkoin.data.preferences

import koin.example.snapnoob.insertkoin.util.AppConstants

interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserId(): Long?

    fun setCurrentUserId(userId: Long?)

    fun getCurrentUserName(): String?

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(userEmail: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)
}