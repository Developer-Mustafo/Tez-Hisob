package uz.coder.tezhisob.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.coder.tezhisob.presentation.fragment.GameFragment

@Component(modules = [ViewModelModule::class,DataModule::class])
@ApplicationScope
interface AppComponent {
    fun inject(fragment: GameFragment)
}