package domain

class Position(private var distance: Int = 0) {
    fun move(decision: Boolean): Int {
        if (decision) {
            distance++
        }
        return distance
    }

    fun distance(): Int = distance
}
