package dev.alexta.apps.business.users.domain

import dev.alexta.apps.business.shared.domain.aggregates.AggregateRoot

internal class User private constructor(
    private val userId: UserId,
    private val userEmailAddress: UserEmailAddress,
) : AggregateRoot {

    internal val id: String = userId.value

    internal val emailAddress: String = userEmailAddress.value

    internal companion object {

        internal fun fromPrimitives(
            id: String,
            emailAddress: String,
        ): User = User(
            userId = UserId(id),
            userEmailAddress = UserEmailAddress(emailAddress),
        )

    }

}
