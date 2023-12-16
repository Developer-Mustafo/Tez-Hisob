package uz.coder.tezhisob.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.coder.tezhisob.presentation.viewmodel.GameViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GameViewModel::class)
    fun bindViewModel(impl:GameViewModel):ViewModel
}