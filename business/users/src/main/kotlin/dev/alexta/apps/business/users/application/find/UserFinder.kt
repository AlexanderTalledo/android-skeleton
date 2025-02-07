package dev.alexta.apps.business.users.application.find

import dev.alexta.apps.business.users.domain.User
import dev.alexta.apps.business.users.domain.UserId
import dev.alexta.apps.business.users.domain.UserRepository
import javax.inject.Inject

internal class UserFinder @Inject constructor(private val repository: UserRepository) {

    suspend fun find(id: UserId): User? = repository.find(id = id)

}
