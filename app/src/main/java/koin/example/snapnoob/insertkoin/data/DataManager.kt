package koin.example.snapnoob.insertkoin.data

import koin.example.snapnoob.insertkoin.data.network.ApiHelper
import koin.example.snapnoob.insertkoin.data.preferences.PreferenceHelper

interface DataManager : PreferenceHelper, ApiHelper {
}