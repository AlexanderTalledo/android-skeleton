package dev.alexta.apps.business.users.application.find

import dev.alexta.apps.shared.infrastructure.queries.QueryResponse

data class FindUserQueryResponse(
    val id: String,
    val emailAddress: String,
) : QueryResponse
