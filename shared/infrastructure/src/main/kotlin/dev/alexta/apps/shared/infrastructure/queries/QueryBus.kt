package dev.alexta.apps.shared.infrastructure.queries

import kotlinx.coroutines.flow.Flow

interface QueryBus {

    fun <T : QueryResponse> ask(query: Query): Flow<T>

}
