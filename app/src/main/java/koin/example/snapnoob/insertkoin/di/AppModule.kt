package koin.example.snapnoob.insertkoin.di

import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.data.network.AppApiHelper
import koin.example.snapnoob.insertkoin.data.preferences.AppPreferenceHelper
import koin.example.snapnoob.insertkoin.ui.detailMovie.presenter.DetailPresenter
import koin.example.snapnoob.insertkoin.ui.detailMovie.presenter.DetailPresenterContract
import koin.example.snapnoob.insertkoin.ui.detailMovie.view.DetailActivityContract
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenter
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenterContract
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract
import koin.example.snapnoob.insertkoin.ui.main.NowPlayingAdapter
import koin.example.snapnoob.insertkoin.ui.main.UpcomingAdapter
import koin.example.snapnoob.insertkoin.ui.main.presenter.MainPresenter
import koin.example.snapnoob.insertkoin.ui.main.presenter.MainPresenterContract
import koin.example.snapnoob.insertkoin.ui.main.view.MainActivityContract
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

val presenterModule: Module = applicationContext {
    factory { LoginPresenter<LoginActivityContract>(get(), get(), get(), get()) as LoginPresenterContract<LoginActivityContract> }
    factory { MainPresenter<MainActivityContract>(get(), get(), get()) as MainPresenterContract<MainActivityContract>}
    factory { DetailPresenter<DetailActivityContract>(get(), get(), get()) as DetailPresenterContract<DetailActivityContract> }
}

val adapterModule: Module = applicationContext {
    factory { NowPlayingAdapter(ArrayList()) }
    factory { UpcomingAdapter(ArrayList()) }
}

val allModule = listOf(appModule, presenterModule, adapterModule)

