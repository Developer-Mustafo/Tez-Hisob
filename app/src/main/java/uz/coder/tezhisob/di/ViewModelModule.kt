package uz.coder.tezhisob.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.coder.tezhisob.presentation.viewmodel.GameViewModel

@Module
interface ViewModelModule {
    @IntoMap
    @Binds
    @ViewModelScope(GameViewModel::class)
    fun bindsViewModel(impl:GameViewModel):ViewModel
}