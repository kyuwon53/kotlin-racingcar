package domain

class Winners(val winners: List<Car>) {
    fun cars(): List<Car> = winners

    companion object {
        fun of(cars: Cars): Winners {
            val maxDistance = cars.getCars().maxOfOrNull { it.currentDistance() } ?: 0
            val winningCars = cars.getCars().filter { it.currentDistance() == maxDistance }
            return Winners(winningCars)
        }
    }
}
