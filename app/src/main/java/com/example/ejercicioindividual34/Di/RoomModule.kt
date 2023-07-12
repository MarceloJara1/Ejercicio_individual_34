package com.example.ejercicioindividual34.Di

import android.content.Context
import androidx.room.Room
import com.example.ejercicioindividual34.Data.Database.MarsDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val MARS_DATABASE_NAME = "mars_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, MarsDb::class.java,MARS_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(db: MarsDb) = db.getMarsDao()
}