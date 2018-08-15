package koin.example.snapnoob.insertkoin.di

import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.data.network.AppApiHelper
import koin.example.snapnoob.insertkoin.data.preferences.AppPreferenceHelper
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenter
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenterContract
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract
import koin.example.snapnoob.insertkoin.util.AppConstants
import koin.example.snapnoob.insertkoin.util.SchedulerProvider
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

val appModule: Module = applicationContext {
    bean { AppPreferenceHelper(get(), AppConstants.PREF_NAME) }
    bean { AppApiHelper() }
    bean { AppDataManager(get(), get()) }
    bean { SchedulerProvider() }
    factory { CompositeDisposable() }
}

val loginModule: Module = applicationContext {
    factory { LoginPresenter<LoginActivityContract>(get(), get(), get()) as LoginPresenterContract<LoginActivityContract> }
}

val mainModule = listOf(appModule, loginModule)