import racingcar.gamemethod.RandomNumberGen
import racingcar.ui.OutputView

fun main() {
    RacingCarGameController(InputView(), OutputView(), RandomNumberGen()).run()
}