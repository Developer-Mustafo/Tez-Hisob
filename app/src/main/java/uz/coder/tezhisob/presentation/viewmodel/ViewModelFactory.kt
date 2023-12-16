package uz.coder.tezhisob.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.coder.tezhisob.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
class ViewModelFactory@Inject constructor(private val viewModelProvides: @JvmSuppressWildcards Map<Class<out ViewModel>,Provider<ViewModel>>):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProvides[modelClass]?.get() as T
    }
}