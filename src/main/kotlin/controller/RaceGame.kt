package controller

import domain.CarNames
import domain.Cars
import domain.MoveDecision
import domain.RaceRecord
import domain.Winners

class RaceGame(
    private val rounds: Int,
    carNames: CarNames,
    moveDecision: MoveDecision,
) {
    private val initialCars = Cars(carNames, moveDecision)

    fun start(): RaceRecord {
        val raceRecord = RaceRecord()
        repeat(rounds) {
            val racedCar = initialCars.race()
            raceRecord.record(racedCar)
        }
        return raceRecord
    }

    fun winners(cars: Cars) = Winners.of(cars)
}
