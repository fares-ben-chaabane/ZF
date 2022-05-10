package fr.benchaabane.data.car.remote

import javax.inject.Inject

class CarRemoteRepository @Inject constructor(private val api: ICarRemoteService) {
    suspend fun getCars(): List<CarJson> = api.getCars()
    suspend fun getCarDetails(vehicleId: String): CarDetailJson =
        api.getCarDetail(vehicleId = vehicleId)
}
