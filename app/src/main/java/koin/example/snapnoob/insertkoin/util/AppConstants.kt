package koin.example.snapnoob.insertkoin.util

object AppConstants {

    internal val APP_DB_NAME = "movie_list.db"
    internal val PREF_NAME = "likeEarth"
    internal val EMPTY_USER_NAME_ERROR = 1001
    internal val EMPTY_PASSWORD_ERROR = 1002
    internal val INVALID_EMAIL_ERROR = 1003
    internal val LOGIN_FAILURE = 1004
    internal val REGISTER_FAILURE = 1005
    internal val NULL_INDEX = -1L

    enum class LoggedInMode constructor(val type: Int){
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FACEBOOK(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}