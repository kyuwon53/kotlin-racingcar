package domain

class RaceJudge {
    fun findWinners(cars: Cars): List<Car> {
        if (cars.getCars().isEmpty()) {
            return emptyList()
        }

        val maxDistance = calculateMaxDistance(cars)
        return filterWinners(cars, maxDistance)
    }

    private fun calculateMaxDistance(cars: Cars): Int {
        return cars.getCars()
            .maxOf { it.currentDistance() }
    }

    private fun filterWinners(
        cars: Cars,
        maxDistance: Int,
    ): List<Car> {
        return cars.getCars()
            .filter { it.currentDistance() == maxDistance }
    }
}
