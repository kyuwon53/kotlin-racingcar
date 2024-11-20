package domain

class Winners(private val cars: Cars) {
    fun determine(): Winners {
        val racedCars = cars.getCars()
        if (racedCars.isEmpty()) {
            return Winners(Cars(emptyList()))
        }

        val maxCar = racedCars.maxOrNull() ?: return Winners(Cars(emptyList()))

        val winningCars = racedCars.filter { it.compareTo(maxCar) == 0 }
        return Winners(Cars(winningCars))
    }

    fun cars(): List<Car> = cars.getCars()
}
