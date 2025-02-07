package dev.alexta.apps.business.shared.domain.value_objects

abstract class EmailAddress(value: String) : ValueObject<String>(value) {

    override fun isValid(): Boolean = value.contains("@")

}
