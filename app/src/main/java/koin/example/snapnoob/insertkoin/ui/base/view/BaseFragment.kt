package koin.example.snapnoob.insertkoin.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import koin.example.snapnoob.insertkoin.util.CommonUtil

abstract class BaseFragment : Fragment(), BaseViewContract {

    private var parentActivity: BaseActivity? = null
    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity){
            val activity = context as BaseActivity?
            this.parentActivity = activity
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun showProgressBar() {
        hideProgressBar()
        progressDialog = CommonUtil.showLoadingProgress(this.context)
    }

    override fun hideProgressBar() {
        if (progressDialog != null && progressDialog?.isShowing!!){
            progressDialog?.cancel()
        }
    }

    fun getBaseActivityy() = parentActivity

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDettached(tag: String)
    }

    abstract fun setUp()
}