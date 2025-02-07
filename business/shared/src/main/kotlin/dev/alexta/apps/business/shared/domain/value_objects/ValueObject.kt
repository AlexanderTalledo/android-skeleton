package dev.alexta.apps.business.shared.domain.value_objects

abstract class ValueObject<T>(val value: T) {

    protected abstract fun isValid(): Boolean

    init {
        require(this.isValid()) { "Invalid ${this::class.simpleName} value: $value" }
    }

}
