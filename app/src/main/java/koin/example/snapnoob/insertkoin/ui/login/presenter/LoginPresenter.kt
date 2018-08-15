package koin.example.snapnoob.insertkoin.ui.login.presenter

import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenter
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract
import koin.example.snapnoob.insertkoin.util.SchedulerProvider

class LoginPresenter<V: LoginActivityContract>(private val appDataManager: AppDataManager, compositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider) : BasePresenter<V>(compositeDisposable = compositeDisposable, schedulerProvider = schedulerProvider), LoginPresenterContract<V> {

    override fun doUserLogin(userName: String, password: String) {
        appDataManager.setCurrentUserName(userName)
        appDataManager.getCurrentUserName()?.let { getView()?.showLoggedUser(it) }
    }

    override fun doUserRegister() {
    }
}