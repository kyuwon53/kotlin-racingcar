package domain

class Race(
    private val cars: Cars,
) {
    fun start(): Cars {
        cars.race()
        return cars
    }

    fun getWinners(): Winners {
        return RaceJudge().findWinners(cars)
    }
}
