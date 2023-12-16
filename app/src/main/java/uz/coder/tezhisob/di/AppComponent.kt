package uz.coder.tezhisob.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import uz.coder.tezhisob.presentation.fragment.GameFragment

@Component(modules = [DataModule::class,ViewModelModule::class])
@ApplicationScope
interface AppComponent {
    fun inject(gameFragment: GameFragment)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):AppComponent
    }
}