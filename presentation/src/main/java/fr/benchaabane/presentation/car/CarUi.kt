package fr.benchaabane.presentation.car

data class CarUi(
    val vehicleId: String,
    val latitude: Double,
    val longitude: Double
)

data class CarUiState(
    val cars: List<CarUi> = emptyList()
)
