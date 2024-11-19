package domain

class Winners(private val cars: Cars) {
    fun determine(): Winners {
        val racedCars = cars.getCars()
        if (racedCars.isEmpty()) {
            return Winners(Cars(emptyList()))
        }

        val maxCar =
            racedCars.reduce { maxCar, currentCar ->
                if (currentCar.isFurtherThan(maxCar)) currentCar else maxCar
            }
        val winningCars = racedCars.filter { it.hasSamePositionAs(maxCar) }
        return Winners(Cars(winningCars))
    }

    fun cars(): List<Car> = cars.getCars()
}
