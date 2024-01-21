package racingcar.domain

import racingcar.gamemethod.RandomNumberGen

class Game(
    val cars: Cars, private var count: Int
) {
    init {
        require(count >= 1) { "시도 횟수는 1 이상이어야 합니다." }
    }

    fun play(numberGenerator: RandomNumberGen) {
        check(!isEnd()) { "남은 시도 횟수가 없습니다" }
        cars.moveAll(numberGenerator)
        count -= 1
    }

    fun isEnd(): Boolean {
        return count <= 0
    }

    fun getWinners(): List<Car> {
        return cars.getWinners()
    }

    companion object {
        fun initGame(carNames: List<String>, trialCount: Int): Game {
            return Game(Cars.of(carNames), trialCount)
        }
    }
}