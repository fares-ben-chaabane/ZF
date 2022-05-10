package fr.benchaabane.data.car.remote

import android.location.Location
import fr.benchaabane.domain.car.CarDetails

internal fun CarDetailJson.toCarDetail() = CarDetails(
    vehicleId = vehicleId,
    latitude = location.latitude,
    longitude = location.longitude
)

internal fun CarLocationJson.toLocation() = Location("").apply {
    latitude = latitude
    longitude = longitude
}
