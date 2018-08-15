package koin.example.snapnoob.insertkoin.ui.base.view

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import koin.example.snapnoob.insertkoin.util.CommonUtil

abstract class BaseActivity : AppCompatActivity(), BaseFragment.CallBack,  BaseViewContract {

    private var progressDialog: ProgressDialog? = null

    override fun showProgressBar() {
        hideProgressBar()
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun hideProgressBar() {
        progressDialog = CommonUtil.showLoadingProgress(this)
    }

}