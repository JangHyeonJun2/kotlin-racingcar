package racingcar.domain

class Car(
    val name:String,
    var position: Int
) {
    init {
        require(name.length in 1..5) { "이름의 길이는 1 이상 5 이하입니다." }
        require(position >= 0) { "위치값은 0 이상이어야 합니다" }
    }

    fun move(power: Int) {
        if (power in 4..9) {
            position += 1
        }
    }

    fun getPosition(): Int {
        return position
    }
}