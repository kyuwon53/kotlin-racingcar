package domain

class Car {
    private var position: Position = Position()

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position.moveForward()
        }
    }

    fun currentDistance(): Int = position.distance()
}
