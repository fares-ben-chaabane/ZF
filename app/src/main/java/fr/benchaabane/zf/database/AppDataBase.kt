package fr.benchaabane.zf.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.benchaabane.data.car.local.CarEntity
import fr.benchaabane.data.car.local.ICarDao

@Database(
    entities = [CarEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun carDao(): ICarDao
}

internal const val DATABASE_NAME = "cars-database"
