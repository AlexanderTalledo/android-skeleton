package dev.alexta.apps.business.users.domain

internal interface UserRepository {

    suspend fun find(id: UserId): User?

}
