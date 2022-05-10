package fr.benchaabane.zf.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import fr.benchaabane.data.car.CarRepository
import fr.benchaabane.data.car.local.CarLocalRepository
import fr.benchaabane.data.car.remote.CarRemoteRepository
import fr.benchaabane.domain.car.ICarRepository
import fr.benchaabane.domain.car.RetrieveCarsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    fun provideCarRepository(
        localRepository: CarLocalRepository,
        remoteRepository: CarRemoteRepository
    ): ICarRepository {
        return CarRepository(localRepository, remoteRepository)
    }

    @Provides
    fun provideRetrieveCarsUseCase(repository: ICarRepository): RetrieveCarsUseCase {
        return RetrieveCarsUseCase(repository)
    }
}
