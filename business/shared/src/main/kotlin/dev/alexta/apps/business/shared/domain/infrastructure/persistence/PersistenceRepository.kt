package dev.alexta.apps.business.shared.domain.infrastructure.persistence

import dev.alexta.apps.business.shared.domain.aggregates.AggregateRoot
import dev.alexta.apps.business.shared.domain.value_objects.Identifier
import kotlinx.coroutines.flow.Flow

interface PersistenceRepository<A : AggregateRoot> {

    fun all(): Flow<List<A>>

    suspend fun byId(id: Identifier): A?

}
