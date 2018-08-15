package koin.example.snapnoob.insertkoin.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.ui.base.view.BaseViewContract
import koin.example.snapnoob.insertkoin.util.SchedulerProvider

abstract class BasePresenter <V: BaseViewContract> internal constructor(protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : BasePresenterContract<V>{

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }

    override fun getView(): V? = view
}