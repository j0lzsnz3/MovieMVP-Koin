package koin.example.snapnoob.insertkoin.ui.login.view

import android.os.Bundle
import android.widget.Toast
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.ui.base.view.BaseActivity
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenterContract
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginActivityContract {

    private val presenter: LoginPresenterContract<LoginActivityContract> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)

        btnLogin.setOnClickListener {
            presenter.doUserLogin(edtUsername.text.toString(), edtPassword.text.toString())
        }
    }

    override fun showLoggedUser(userName: String) {
        Toast.makeText(this, "User logged $userName", Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDettached(tag: String) {
    }
}
