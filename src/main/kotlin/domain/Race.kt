package domain

class Race(
    private val cars: Cars,
) {
    fun start(): Cars {
        cars.race()
        return cars
    }
}
