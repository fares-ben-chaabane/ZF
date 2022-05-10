package fr.benchaabane.data.car.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carTable")
data class CarEntity(
    @PrimaryKey
    val vehicleId: String,
    @ColumnInfo(name = "latitude", defaultValue = "")
    val latitude: Double,
    @ColumnInfo(name = "longitude", defaultValue = "")
    val longitude: Double
)
