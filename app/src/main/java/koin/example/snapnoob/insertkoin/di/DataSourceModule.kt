package koin.example.snapnoob.insertkoin.di

import koin.example.snapnoob.insertkoin.data.AppDataManager
import koin.example.snapnoob.insertkoin.data.DataManager
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

val localDataSourceModule: Module = applicationContext {
    bean { AppDataManager(get()) as DataManager }
}