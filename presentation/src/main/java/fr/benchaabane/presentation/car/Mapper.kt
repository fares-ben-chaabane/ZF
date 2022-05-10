package fr.benchaabane.presentation.car

import fr.benchaabane.domain.car.CarDetails

internal fun CarDetails.toUi() = CarUi(
    vehicleId = vehicleId,
    latitude = latitude,
    longitude = longitude
)