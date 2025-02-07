package dev.alexta.apps.business.shared.infrastructure.persistence.room.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @[PrimaryKey ColumnInfo(name = COLUMN_NAME_UID)]
    val uid: String,
    @ColumnInfo(name = COLUMN_NAME_EMAIL_ADDRESS)
    val emailAddress: String,
) {

    internal companion object {

        internal const val TABLE_NAME = "users"

        internal const val COLUMN_NAME_UID = "unique_id"

        internal const val COLUMN_NAME_EMAIL_ADDRESS = "email_address"

    }

}
