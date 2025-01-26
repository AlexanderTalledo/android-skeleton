package dev.alexta.apps.business.shared.domain.infrastructure.persistence

import dev.alexta.apps.business.shared.domain.aggregates.AggregateRoot

interface PersistenceRepository<A : AggregateRoot> {

    suspend fun byId(): A

}
