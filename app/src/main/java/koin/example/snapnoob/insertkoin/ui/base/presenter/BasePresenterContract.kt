package koin.example.snapnoob.insertkoin.ui.base.presenter

import koin.example.snapnoob.insertkoin.ui.base.view.BaseViewContract

interface BasePresenterContract<V: BaseViewContract> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}