package dev.alexta.apps.business.shared.infrastructure.persistence.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.alexta.apps.business.shared.infrastructure.persistence.room.users.UsersDao
import dev.alexta.apps.business.shared.infrastructure.persistence.room.users.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    exportSchema = true,
    version = SkeletonDatabase.VERSION,
)
internal abstract class SkeletonDatabase : RoomDatabase() {

    internal abstract fun usersDao(): UsersDao

    internal companion object {

        internal const val NAME = "skeleton.db"

        internal const val VERSION = 1

    }

}
