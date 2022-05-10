package fr.benchaabane.data.car.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ICarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCar(car: CarEntity)

    @Query("DELETE FROM carTable")
    suspend fun deleteAllCars()

    @Transaction
    @Query("SELECT * FROM carTable")
    suspend fun getCars(): List<CarEntity>

    @Transaction
    @Query("SELECT * FROM carTable WHERE vehicleId=:vehicleId")
    suspend fun getCarById(vehicleId: String): CarEntity
}
