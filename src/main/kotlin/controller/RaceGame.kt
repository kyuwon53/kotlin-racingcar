package controller

import domain.CarNames
import domain.Cars
import domain.MoveDecision
import domain.Race
import domain.RaceJudge
import view.ResultView

class RaceGame(
    private val rounds: Int,
    carNames: CarNames,
    moveDecision: MoveDecision,
) {
    private val initialCars = Cars(carNames, moveDecision)

    fun start(): Cars {
        return (1..rounds).fold(initialCars) { currentCars, _ ->
            val currentRace = Race(currentCars).start()
            ResultView.displayRoundResults(currentCars)
            currentRace
        }
    }

    fun winners(cars: Cars) = RaceJudge().findWinners(cars)
}
