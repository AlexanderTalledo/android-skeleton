package dev.alexta.apps.business.users.application.find

import dev.alexta.apps.shared.infrastructure.queries.QueryHandler
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class FindUserQueryHandler @Inject constructor(
    private val finder: UserFinder,
) : QueryHandler<FindUserQuery, FindUserQueryResponse> {

    override fun handle(query: FindUserQuery): Flow<FindUserQueryResponse> {
        TODO("Not yet implemented")
    }

}
