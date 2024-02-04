class InputView {
    fun submitCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val carNames: String = readln()
        return carNames.split(",")
    }

    fun submitCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val input: String = readln()
        validateNumberFormat(input)
        return input.toInt()
    }

    private fun validateNumberFormat(input: String) {
        require(input.all(Char::isDigit)) { "시도 횟수는 숫자여야합나디."}
    }
}