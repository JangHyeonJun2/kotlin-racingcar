package racingcar.ui

import racingcar.ui.dto.CarDto

class OutputView {
    fun printCars(carDtos: List<CarDto>) {
        carDtos.forEach { carDto -> println("${carDto.name} : ${"-".repeat(carDto.position)}") }
        println()
    }

    fun printWinners(carDtos: List<CarDto>) {
        println("최종 우승자: ${carDtos.joinToString(",") { carDto ->  carDto.name }}")
    }
}