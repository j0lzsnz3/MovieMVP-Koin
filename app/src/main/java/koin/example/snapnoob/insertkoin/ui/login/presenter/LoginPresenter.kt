package koin.example.snapnoob.insertkoin.ui.login.presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import io.reactivex.disposables.CompositeDisposable
import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.ui.base.presenter.BasePresenter
import koin.example.snapnoob.insertkoin.ui.login.view.LoginActivityContract
import koin.example.snapnoob.insertkoin.util.AppConstants
import koin.example.snapnoob.insertkoin.util.SchedulerProvider

class LoginPresenter<V: LoginActivityContract>(private val context: Context, private val appDataManager: AppDataManager, compositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider) : BasePresenter<V>(compositeDisposable = compositeDisposable, schedulerProvider = schedulerProvider), LoginPresenterContract<V> {

    override fun doUserGoogleLogin(): Intent {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(context, gso)

        return mGoogleSignInClient.signInIntent
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 9001 && resultCode != 0) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

            Log.d("LoginPresenter", "onActivityResult")
            updateSocmedUserInSharedPref(account, AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE)
            getView()?.openMainActivity()
            account.displayName?.let { getView()?.showLoggedUser(it) }
        }
    }

    private fun updateSocmedUserInSharedPref(account: GoogleSignInAccount, loggedInMode: AppConstants.LoggedInMode) {
        account.let {
            appDataManager.setCurrentUserName(it.displayName)
        }

        appDataManager.setCurrentUserLoggedInMode(loggedInMode)
    }

    override fun getStatusUserLogged(): Boolean = !appDataManager.getCurrentUserName().isNullOrEmpty()
}