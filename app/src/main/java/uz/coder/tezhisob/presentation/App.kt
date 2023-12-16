package uz.coder.tezhisob.presentation

import android.app.Application
import uz.coder.tezhisob.di.DaggerAppComponent

class App:Application() {
    val component by lazy {
        DaggerAppComponent.create()
    }
}