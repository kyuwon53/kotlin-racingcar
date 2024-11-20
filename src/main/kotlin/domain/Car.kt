package domain

class Car(
    val name: String,
    position: Int = 0,
) : Comparable<Car> {
    init {
        require(name.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    var position: Int = position
        private set

    fun move(shouldMove: Boolean): Car {
        if (shouldMove) {
            position++
        }
        return Car(name, position)
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }
}
