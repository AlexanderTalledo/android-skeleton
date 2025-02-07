package dev.alexta.apps.shared.infrastructure.queries

import kotlinx.coroutines.flow.Flow

interface QueryHandler<in Q : Query, out R : QueryResponse> {

    fun handle(query: Q): Flow<R>

}
