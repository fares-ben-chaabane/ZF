package fr.benchaabane.data.car.remote

data class CarJson(
    val vehicleId: String,
    val isActive: Boolean
)

data class CarDetailJson(
    val vehicleId: String,
    val location: CarLocationJson
)

data class CarLocationJson(
    val latitude: Double,
    val longitude: Double
)
