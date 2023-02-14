package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `값이 4 이상인 경우 이동한다`(number: Int) {
        val car = Car("Tom")
        car.tryMove(TestNumberGenerator(number).generate())
        assertThat(car.moveCount).isEqualTo(EXPECTED_MOVE_COUNT)
        println(car.moveCount)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `값이 3 이하인 경우 이동하지 않는다`(number: Int) {
        val car = Car("Tom")
        car.tryMove(TestNumberGenerator(number).generate())
        assertThat(car.moveCount).isEqualTo(INITIAL_MOVE_COUNT)
    }

    @Test
    fun `자동차 이름은 5자 이하의 길이를 가진다`() {
        assertThrows<IllegalArgumentException> { Car("aaaaaaa") }
    }

    @Test
    fun `자동차 이름은 비어있을 수 없다`() {
        assertThrows<IllegalArgumentException> { Car("") }
    }

    companion object {
        private const val INITIAL_MOVE_COUNT = 0
        private const val EXPECTED_MOVE_COUNT = 1
    }
}

class TestNumberGenerator(private val number: Int) : CarNumberGenerator {
    override fun generate(): Int {
        return number
    }
}
