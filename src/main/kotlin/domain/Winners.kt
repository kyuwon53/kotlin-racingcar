package domain

class Winners(private val cars: Cars) {
    private val winners: List<Car> by lazy {
        val maxDistance = cars.getCars().maxOfOrNull { it.currentDistance() } ?: 0
        cars.getCars().filter { it.currentDistance() == maxDistance }
    }

    fun cars(): List<Car> = winners

    fun determine(): Winners {
        return Winners(cars)
    }
}
