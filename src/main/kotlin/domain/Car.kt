package domain

class Car(
    val name: CarName,
    private val position: Position = Position(),
) {
    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position.moveForward()
        }
    }

    fun currentDistance(): Int = position.distance()

    constructor(name: CarName, initialPosition: Int) : this(name, Position(initialPosition))

    @JvmInline
    value class CarName(val value: String) {
        init {
            require(value.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
            require(value.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
        }
    }
}
