package uz.coder.tezhisob.di

import dagger.Binds
import dagger.Module
import uz.coder.tezhisob.data.GameRepositoryImpl
import uz.coder.tezhisob.domain.GameRepository

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRepositoryImpl(impl:GameRepositoryImpl):GameRepository
}