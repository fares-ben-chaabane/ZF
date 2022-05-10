package fr.benchaabane.data.car.local

import fr.benchaabane.domain.car.CarDetails

internal fun CarDetails.toEntity() = CarEntity(
    vehicleId = vehicleId,
    latitude = latitude,
    longitude = longitude
)

internal fun CarEntity.toCarDetail() = CarDetails(
    vehicleId = vehicleId,
    latitude = latitude,
    longitude = longitude
)
