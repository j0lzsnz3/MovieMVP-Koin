package koin.example.snapnoob.insertkoin.ui.login.view

import koin.example.snapnoob.insertkoin.ui.base.view.BaseViewContract

interface LoginActivityContract : BaseViewContract {

    fun showLoggedUser(userName: String)
}