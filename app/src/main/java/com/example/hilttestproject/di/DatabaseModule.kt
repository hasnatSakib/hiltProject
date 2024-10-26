package com.example.hilttestproject.di

import ContactDao
import android.content.Context
import androidx.room.Room
import com.example.hilttestproject.data.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ContactDatabase {
        return Room.databaseBuilder(
            context,
            ContactDatabase::class.java,
            "contact_database"
        ).build()
    }

    @Provides
    fun provideContactDao(database: ContactDatabase): ContactDao {
        return database.contactDao()
    }
}