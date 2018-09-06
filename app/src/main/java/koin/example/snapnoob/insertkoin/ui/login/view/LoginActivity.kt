package koin.example.snapnoob.insertkoin.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.ui.base.view.BaseActivity
import koin.example.snapnoob.insertkoin.ui.login.presenter.LoginPresenterContract
import koin.example.snapnoob.insertkoin.ui.main.view.MainActivity
import koin.example.snapnoob.insertkoin.ui.register.view.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginActivityContract {

    private val presenter: LoginPresenterContract<LoginActivityContract> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)

        /** if (presenter.getStatusUserLogged()) {
            openMainActivity()
        }

        btnGoogleSign.setOnClickListener { startActivityForResult(presenter.doUserGoogleLogin(), 9001) } **/
        openMainActivity()
    }

    override fun showLoggedUser(userName: String) {
        Toast.makeText(this, "User logged $userName", Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDettached(tag: String) {
    }

    override fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
    }

}
