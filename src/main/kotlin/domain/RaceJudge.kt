package domain

class RaceJudge {
    fun findWinners(cars: Cars): Winners {
        val maxDistance =
            cars
                .getCars()
                .maxOfOrNull { it.currentDistance() }
                ?: return Winners(emptyList())

        val winners =
            cars
                .getCars()
                .filter { it.currentDistance() == maxDistance }

        return Winners(winners)
    }
}
