package koin.example.snapnoob.insertkoin.ui.login.presenter

import android.content.Intent
import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenterContract
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract

interface LoginPresenterContract<V: LoginActivityContract> : BasePresenterContract<V> {

    fun doUserGoogleLogin(): Intent

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

    fun getStatusUserLogged(): Boolean
}