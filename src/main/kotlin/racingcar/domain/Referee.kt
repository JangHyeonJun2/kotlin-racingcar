package racingcar.domain

class Referee {
    fun getWinner(cars: List<RacingCar>): List<String> {
        val sortedCars = cars.sortedByDescending { it.movingState }
        val maxState = sortedCars.first().movingState

        return sortedCars.filter { car -> car.movingState == maxState }.map { car -> car.name }
    }
}
