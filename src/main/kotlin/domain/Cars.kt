package domain

class Cars(
    private val cars: List<Car>,
    private val moveDecision: MoveDecision,
) {
    fun race() {
        cars.forEach { car ->
            car.move(moveDecision.shouldMove())
        }
    }

    fun getDistances(): List<Int> = cars.map { it.currentDistance() }
}
