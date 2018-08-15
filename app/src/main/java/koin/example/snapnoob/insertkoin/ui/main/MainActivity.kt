package koin.example.snapnoob.insertkoin.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import koin.example.snapnoob.insertkoin.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val presenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
