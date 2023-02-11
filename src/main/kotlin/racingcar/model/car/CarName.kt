package racingcar.model.car

class CarName(val name: String) {
    init {
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE
        }
    }

    fun toDto() = CarNameDto(name)

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5

        private const val CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름 길이의 범위는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하입니다."
    }
}

class CarNameDto(val name: String)
