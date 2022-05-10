package fr.benchaabane.zf.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.benchaabane.data.car.local.ICarDao
import fr.benchaabane.zf.database.AppDataBase
import fr.benchaabane.zf.database.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCarDao(database: AppDataBase): ICarDao = database.carDao()
}
