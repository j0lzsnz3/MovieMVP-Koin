package koin.example.snapnoob.insertkoin.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import koin.example.snapnoob.insertkoin.util.AppConstants

class AppPreferenceHelper(context: Context, prefFileName: String) : PreferenceHelper {

    companion object {
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_USER_ID"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode(): Int = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, 0)

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit {
            putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type)
        }
    }

    override fun getCurrentUserId(): Long? {
        val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return when (userId) {
            AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        mPrefs.edit { putLong(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun getCurrentUserName(): String? = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null)

    override fun setCurrentUserName(userName: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String? = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null)

    override fun setCurrentUserEmail(userEmail: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, userEmail) }

    override fun getAccessToken(): String? = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)

    override fun setAccessToken(accessToken: String?) = mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }
}