package koin.example.snapnoob.insertkoin.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog

object PermissionUtil {
    const val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 122
    const val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123
    const val MY_PERMISSIONS_REQUEST_READ_DEVICE_ID = 124
    const val MY_PERMISSIONS_REQUEST_VIBRATE = 125
    const val MY_PERMISSIONS_REQUEST_ACCESS_NETWORK_STATE = 126
    const val MY_PERMISSIONS_CAMERA = 127
    const val MY_PERMISSIONS_AUDIO = 128
    const val MY_PERMISSIONS_FINE_LOCATION = 129
    const val MY_PERMISSIONS_COARSE_LOCATION = 129

    fun requestReadExternalPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk mengakses penyimpanan eksternal?",
                            arrayOf(permission), MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestWriteExternalPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk menyimpan ke data eksternal?",
                            arrayOf(permission), MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestCameraPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = android.Manifest.permission.CAMERA
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk mengakses kamera?",
                            arrayOf(permission), MY_PERMISSIONS_CAMERA)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_CAMERA)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestAudioPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.RECORD_AUDIO
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk mengakses mikrofon?",
                            arrayOf(permission), MY_PERMISSIONS_AUDIO)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_AUDIO)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestFineLocationPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk mengakses lokasi?",
                            arrayOf(permission), MY_PERMISSIONS_FINE_LOCATION)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_FINE_LOCATION)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestCoarseLocationPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.ACCESS_COARSE_LOCATION
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan aplikasi untuk mengakses lokasi?",
                            arrayOf(permission), MY_PERMISSIONS_COARSE_LOCATION)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_COARSE_LOCATION)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestDeviceIdPermission(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.READ_PHONE_STATE
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Aplikasi membutuhkan perangkat id Anda, ijinkan?",
                            arrayOf(permission), MY_PERMISSIONS_REQUEST_READ_DEVICE_ID)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_REQUEST_READ_DEVICE_ID)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    fun requestVibrate(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.VIBRATE
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            return if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Aktifkan Fitur Vibrasi?",
                            "Ijinkan aplikasi untuk mengelola fitur vibrasi pada perangkat Anda?",
                            arrayOf(permission), MY_PERMISSIONS_REQUEST_VIBRATE)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_REQUEST_VIBRATE)
                }
                false
            } else {
                true
            }
        } else {
            return true
        }
    }

    fun requestAccessNetworkState(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        val permission = Manifest.permission.ACCESS_NETWORK_STATE
        return if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (isNotGranted(context, permission)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)) {
                    showAlertDialog(context, "Ijinkan Aplikasi?", "Ijinkan Aplikasi untuk membaca koneksi jaringan Anda?",
                            arrayOf(permission), MY_PERMISSIONS_REQUEST_ACCESS_NETWORK_STATE)
                } else {
                    requestPermission(context, arrayOf(permission), MY_PERMISSIONS_REQUEST_ACCESS_NETWORK_STATE)
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    private fun showAlertDialog(context: Context, title: String, message: String, permissions: Array<String>, flag: Int) {
        val alertBuilder = AlertDialog.Builder(context)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle(title)
        alertBuilder.setMessage(message)
        alertBuilder.setPositiveButton(android.R.string.yes) { _, _ ->
            ActivityCompat.requestPermissions(context as Activity, permissions, flag)
        }
        val alert = alertBuilder.create()
        alert.show()
    }

    private fun isNotGranted(context: Context, manifestPermission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, manifestPermission) != PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(context: Activity, permissions: Array<String>, flag: Int) {
        ActivityCompat.requestPermissions(context, permissions, flag)
    }
}