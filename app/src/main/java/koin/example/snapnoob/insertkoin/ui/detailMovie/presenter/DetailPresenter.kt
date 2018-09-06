package koin.example.snapnoob.insertkoin.ui.detailMovie.presenter

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenter
import koin.example.snapnoob.insertkoin.ui.detailMovie.view.DetailActivityContract
import koin.example.snapnoob.insertkoin.util.SchedulerProvider

class DetailPresenter<V: DetailActivityContract>(private val appDataManager: AppDataManager, compositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider) : BasePresenter<V>(schedulerProvider, compositeDisposable), DetailPresenterContract<V> {

    override fun loadMovieDetail(query: String) {
        /** compositeDisposable.add(appDataManager.performSearchMovieData(query)
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({movieResponse ->

                }, {
                    Log.e("DetailPresenter", it.message)
                })) **/
    }
}