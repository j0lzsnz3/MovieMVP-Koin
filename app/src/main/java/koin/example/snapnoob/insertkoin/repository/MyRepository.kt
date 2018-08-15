package koin.example.snapnoob.insertkoin.repository

class MyRepository : Repository {
    override fun giveHello(): String = "Hello! Please insert the Koin"
}