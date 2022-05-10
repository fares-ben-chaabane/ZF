package fr.benchaabane.data.car.local

import fr.benchaabane.domain.car.CarDetails
import javax.inject.Inject

class CarLocalRepository @Inject constructor(private val dao: ICarDao) {
    suspend fun saveCar(carDetail: CarDetails) = dao.saveCar(carDetail.toEntity())
    suspend fun deleteCars() = dao.deleteAllCars()
    suspend fun getCars(): List<CarDetails> = dao.getCars().map { it.toCarDetail() }
    suspend fun getCarById(vehicleId: String): CarDetails =
        dao.getCarById(vehicleId = vehicleId).toCarDetail()
}
