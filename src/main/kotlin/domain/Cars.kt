package domain

class Cars(
    private val cars: List<Car>,
    private val moveDecision: MoveDecision,
) {
    companion object {
        fun ofCarNames(
            carNames: CarNames,
            moveDecision: MoveDecision,
        ): Cars {
            return Cars(carNames.names().map { Car(it) }, moveDecision)
        }
    }

    fun race() {
        cars.forEach { car ->
            car.move(moveDecision.shouldMove())
        }
    }

    fun getCars(): List<Car> = cars
}
