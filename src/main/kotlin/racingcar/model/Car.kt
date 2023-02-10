package racingcar.model

import racingcar.utils.Validator

class Car(
    val name: String,
) : Comparable<Car> {
    var position: Int = 0
        private set

    init {
        val validator = Validator()
        validator.checkCarNameLength(name)
    }

    fun move() = ++position

    override fun compareTo(other: Car) = this.position - other.position

    override fun equals(other: Any?): Boolean {
        if (other is Car) {
            return this.position == other.position
        }

        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }
}
