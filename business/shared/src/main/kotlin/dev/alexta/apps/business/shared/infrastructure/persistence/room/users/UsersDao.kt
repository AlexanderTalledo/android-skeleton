package dev.alexta.apps.business.shared.infrastructure.persistence.room.users

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} WHERE ${UserEntity.COLUMN_NAME_UID} = :id")
    suspend fun getById(id: String): UserEntity?

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME}")
    fun observeAll(): Flow<List<UserEntity>>

}
