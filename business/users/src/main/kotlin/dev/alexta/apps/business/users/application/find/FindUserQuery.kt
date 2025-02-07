package dev.alexta.apps.business.users.application.find

import dev.alexta.apps.shared.infrastructure.queries.Query

data class FindUserQuery(internal val id: String) : Query
