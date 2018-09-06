package koin.example.snapnoob.insertkoin

import android.app.Application
import koin.example.snapnoob.insertkoin.di.allModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, allModule)
    }
}