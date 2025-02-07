package dev.alexta.apps.business.shared.domain.value_objects

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

abstract class Identifier(value: String) : ValueObject<String>(value) {

    @OptIn(ExperimentalUuidApi::class)
    override fun isValid(): Boolean = try {
        Uuid.parse(value)
        true
    } catch (_: IllegalArgumentException) {
        false
    }

}
