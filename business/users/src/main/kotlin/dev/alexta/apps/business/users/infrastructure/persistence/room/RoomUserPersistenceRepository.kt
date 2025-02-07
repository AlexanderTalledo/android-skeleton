package dev.alexta.apps.business.users.infrastructure.persistence.room

import dev.alexta.apps.business.shared.domain.infrastructure.persistence.PersistenceRepository
import dev.alexta.apps.business.shared.domain.value_objects.Identifier
import dev.alexta.apps.business.shared.infrastructure.persistence.room.users.UsersDao
import dev.alexta.apps.business.shared.infrastructure.persistence.room.users.UserEntity
import dev.alexta.apps.business.users.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RoomUserPersistenceRepository @Inject constructor(
    private val usersDao: UsersDao,
) : PersistenceRepository<User> {

    override fun all(): Flow<List<User>> = usersDao.observeAll()
        .map(List<UserEntity>::toDomain)

    override suspend fun byId(id: Identifier): User? = usersDao.getById(id = id.value)
        ?.let(UserEntity::toDomain)

}

private fun List<UserEntity>.toDomain() = map(UserEntity::toDomain)

private fun UserEntity.toDomain() = User.fromPrimitives(
    id = uid,
    emailAddress = emailAddress,
)