package controller

import domain.CarNames
import domain.Cars
import domain.MoveDecision
import domain.Race

class RaceGame(
    carNames: CarNames,
    rounds: Int,
    moveDecision: MoveDecision,
) {
    private val race = Race(Cars.ofCarNames(carNames, moveDecision), rounds)

    fun start() {
        race.start()
    }
}
