package koin.example.snapnoob.insertkoin.ui.main

import koin.example.snapnoob.insertkoin.repository.Repository

class MainPresenter(private val repository: Repository) {
    fun sayHello() = repository.giveHello()
}