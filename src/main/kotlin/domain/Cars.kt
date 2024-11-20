package domain

class Cars(
    private val cars: List<Car>,
    private val moveDecision: MoveDecision = RandomMoveDecision(),
) {
    constructor(
        carNames: CarNames,
        moveDecision: MoveDecision,
    ) : this(
        carNames.values().map { Car(it) },
        moveDecision,
    )

    fun race(): Cars {
        return Cars(
            cars.map { car ->
                car.move(moveDecision.shouldMove())
            },
        )
    }

    fun getCars(): List<Car> = cars
}
