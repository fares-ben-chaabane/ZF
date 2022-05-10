package fr.benchaabane.data.car

import android.location.Location
import fr.benchaabane.data.car.local.CarLocalRepository
import fr.benchaabane.data.car.remote.CarRemoteRepository
import fr.benchaabane.data.car.remote.toCarDetail
import fr.benchaabane.data.car.remote.toLocation
import fr.benchaabane.domain.car.CarDetails
import fr.benchaabane.domain.car.ICarRepository
import fr.benchaabane.domain.common.Result
import javax.inject.Inject

class CarRepository @Inject constructor(
    private val localRepository: CarLocalRepository,
    private val remoteRepository: CarRemoteRepository
) : ICarRepository {

    private val inglewood = Location("").apply {
        latitude = 46.5223916
        longitude = 6.6314437
    }

    private suspend fun saveRemoteCars() {
        remoteRepository.getCars().filter { it.isActive }.onEach { remoteCar ->
            remoteRepository.getCarDetails(remoteCar.vehicleId)
                .also { remoteCarDetail ->
                    if (inglewood.distanceTo(remoteCarDetail.location.toLocation()) < 1.0) {
                        localRepository.saveCar(remoteCarDetail.toCarDetail())
                    }
                }
        }
    }

    override suspend fun retrieveCars(): Result<List<CarDetails>> {
        return try {
            saveRemoteCars()
            Result.Success(localRepository.getCars())
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}
