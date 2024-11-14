package domain

class Position {
    private var distance: Int = 0

    fun moveForward(): Int = distance++

    fun display(): String = "-".repeat(distance)
}
