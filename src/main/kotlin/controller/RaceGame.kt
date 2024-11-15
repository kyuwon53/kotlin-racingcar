package controller

import domain.Car
import domain.Cars
import domain.MoveDecision
import view.ResultView

class RaceGame(
    carCount: Int,
    private val rounds: Int,
    moveDecision: MoveDecision,
) {
    private val cars = Cars(List(carCount) { Car() }, moveDecision)

    fun start() {
        repeat(rounds) {
            cars.race()
            ResultView.displayRoundResults(cars)
        }
    }
}
