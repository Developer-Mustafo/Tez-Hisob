package uz.coder.tezhisob.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelScope(val viewModelKey:KClass<out ViewModel>)
