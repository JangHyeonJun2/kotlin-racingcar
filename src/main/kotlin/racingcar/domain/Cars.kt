package racingcar.domain

import racingcar.gamemethod.RandomNumberGen

class Cars(
    val cars: List<Car>
) {
    fun moveAll(numberGenerator: RandomNumberGen) {
        cars.forEach { car -> car.move(numberGenerator.gen()) }
    }

    fun getWinners(): List<Car> {
        val fastestPosition: Int = cars.maxOf { car -> car.getPosition() }
        return cars.filter { car -> car.getPosition() == fastestPosition }
    }
}