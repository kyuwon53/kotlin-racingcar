package controller

import domain.CarNames
import domain.Cars
import domain.MoveDecision
import domain.Race
import view.ResultView

class RaceGame(
    private val rounds: Int,
    carNames: CarNames,
    moveDecision: MoveDecision,
) {
    private val race = Race(Cars(carNames, moveDecision))

    fun start() {
        repeat(rounds) {
            val result = race.start()
            ResultView.displayRoundResults(result)
        }
    }

    fun winners() = race.getWinners()
}
