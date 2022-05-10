package fr.benchaabane.domain.car

import fr.benchaabane.domain.common.Result

interface ICarRepository {
    suspend fun retrieveCars(): Result<List<CarDetails>>
}
