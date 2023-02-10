package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun beforeEach() {
        this.validator = Validator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["sooda, buna", "sooda,buna", "   sooda,  buna  "])
    fun `자동차 이름 중복 노말 테스트`(input: String) {
        assertDoesNotThrow {
            val names = input
                .split(CAR_NAME_DELIMITER)
                .removeBlank()
            validator.checkCarNames(names)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soodal, soodal", "buna, buna"])
    fun `자동차 이름 중복 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            val names = input
                .split(CAR_NAME_DELIMITER)
                .removeBlank()
            validator.checkCarNames(names)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString(), "5", "6"])
    fun `시도 횟수 노말 테스트`(input: String) {
        assertDoesNotThrow {
            validator.checkRoundCount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString(), "-1", "*", "", "otter", "buna"])
    fun `시도 횟수 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkRoundCount(input)
        }
    }
}
