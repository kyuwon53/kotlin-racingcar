package domain

class RaceJudge {
    fun findWinners(cars: Cars): Winners {
        if (cars.getCars().isEmpty()) {
            return Winners(emptyList())
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
    ): Winners {
        val winners =
            cars.getCars()
                .filter { it.currentDistance() == maxDistance }
        return Winners(winners)
    }
}
