package koin.example.snapnoob.insertkoin.ui.main.presenter

import android.util.Log
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.data.network.ApiEndPoint
import koin.example.snapnoob.insertkoin.data.network.MovieData
import koin.example.snapnoob.insertkoin.data.network.MovieResponse
import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenter
import koin.example.snapnoob.insertkoin.ui.main.view.MainActivityContract
import koin.example.snapnoob.insertkoin.util.SchedulerProvider

class MainPresenter<V: MainActivityContract>(private val appDataManager: AppDataManager, compositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider) : BasePresenter<V>(compositeDisposable = compositeDisposable, schedulerProvider = schedulerProvider), MainPresenterContract<V> {

    override fun loadNowPlayingData() {
        compositeDisposable.add(appDataManager.performNowPlayingMovie()
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe ({ movieResponse ->
                    getView()?.displayNowPlayingMovie(movieResponse.results)
                }, {
                    Log.e("NowPlaying", it.message)
                }))
    }

    override fun loadUpcomingData() {
        compositeDisposable.add(appDataManager.performUpcomingMovie()
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ movieResponse ->
                    getView()?.displayUpcomingMovie(movieResponse.results)
                }, {
                    Log.e("Upcoming", it.message)
                }))
    }
}