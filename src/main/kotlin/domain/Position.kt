package domain

class Position {
    private var distance: Int = 0

    fun moveForward(): Int = distance++

    fun distance(): Int = distance
}
