package koin.example.snapnoob.insertkoin.ui.login.presenter

import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenterContract
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract

interface LoginPresenterContract<V: LoginActivityContract> : BasePresenterContract<V> {

    fun doUserLogin(userName: String, password: String)

    fun doUserRegister()


}