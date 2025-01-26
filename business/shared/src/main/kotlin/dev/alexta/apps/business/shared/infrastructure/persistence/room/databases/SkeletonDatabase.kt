package dev.alexta.apps.business.shared.infrastructure.persistence.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    exportSchema = true,
    version = SkeletonDatabase.VERSION,
)
internal abstract class SkeletonDatabase : RoomDatabase() {

    internal companion object {

        internal const val NAME = "skeleton.db"

        internal const val VERSION = 1

    }

}
