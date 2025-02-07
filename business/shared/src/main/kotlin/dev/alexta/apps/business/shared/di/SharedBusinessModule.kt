package dev.alexta.apps.business.shared.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.alexta.apps.business.shared.infrastructure.persistence.room.databases.SkeletonDatabase
import dev.alexta.apps.business.shared.infrastructure.persistence.room.users.UsersDao
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal abstract class SharedBusinessModule {

    internal companion object {

        @[Provides Singleton]
        internal fun provideUsersDao(database: SkeletonDatabase): UsersDao = database.usersDao()

        @[Provides Singleton]
        internal fun provideSkeletonDatabase(
            @ApplicationContext context: Context,
        ): SkeletonDatabase = Room.databaseBuilder(
            context = context,
            klass = SkeletonDatabase::class.java,
            name = context.getDatabasePath(SkeletonDatabase.NAME).absolutePath,
        ).build()

    }

}
