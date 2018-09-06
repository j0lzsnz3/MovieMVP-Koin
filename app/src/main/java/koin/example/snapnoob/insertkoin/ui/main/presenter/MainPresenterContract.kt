package koin.example.snapnoob.insertkoin.ui.main.presenter

import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenterContract
import koin.example.snapnoob.insertkoin.ui.main.view.MainActivityContract

interface MainPresenterContract<V: MainActivityContract> : BasePresenterContract<V> {

    fun loadNowPlayingData()

    fun loadUpcomingData()
}