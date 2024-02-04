import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.gamemethod.RandomNumberGen
import racingcar.ui.OutputView
import racingcar.ui.dto.CarDto

class RacingCarGameController (
    val inputView: InputView,
    val outputView: OutputView,
    val gameGen: RandomNumberGen
) {
    fun run() {
        val carNames: List<String> = inputView.submitCarNames()
        val trialCount: Int = inputView.submitCount()
        val racingGame: Game = Game.initGame(carNames, trialCount)

        while (!racingGame.isEnd()) {
            racingGame.play(gameGen)
            outputView.printCars(ofCarDtos(racingGame.cars.cars))
        }

        outputView.printWinners(ofCarDtos(racingGame.getWinners()))
    }

    private fun ofCarDtos(cars: List<Car>) = cars.map { CarDto( it.name, it.position) }
}