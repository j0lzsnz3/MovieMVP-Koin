package koin.example.snapnoob.insertkoin.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtil {


    const val NETWORK_NOT_CONNECTED = -1
    const val NETWORK_CONNECTED = 1
    //this variable is equal with -> ConnectivityManager.EXTRA_INET_CONDITION

    fun isWifi(type: Int): Boolean {
        return type == ConnectivityManager.TYPE_WIFI
    }

    fun isBroadband(type: Int): Boolean {
        return type == ConnectivityManager.TYPE_MOBILE
    }

    fun isConnected(context: Context): Boolean {
        val status = getConnectivityStatus(context)
        return status == NETWORK_CONNECTED
    }

    private fun getConnectionManager(context: Context): ConnectivityManager? {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @SuppressLint("MissingPermission")
    fun getNetworkInfo(context: Context, connectivityManager: ConnectivityManager): NetworkInfo? {
        return if (PermissionUtil.requestAccessNetworkState(context)) {
            connectivityManager.activeNetworkInfo
        } else {
            getNetworkInfo(context, connectivityManager)
            null
        }
    }

    private fun getConnectivityStatus(context: Context): Int {
        val cm = getConnectionManager(context)!!
        val activeNetwork = getNetworkInfo(context, cm)
        if (null != activeNetwork) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI)
                return NETWORK_CONNECTED

            if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                return NETWORK_CONNECTED
        }
        return NETWORK_NOT_CONNECTED
    }

}