package domain

import view.ResultView

class Race(
    private val cars: Cars,
    private val rounds: Int,
) {
    fun start() {
        repeat(rounds) {
            cars.race()
            ResultView.displayRoundResults(cars)
        }
    }

    fun getWinners(): Winners {
        return RaceJudge().findWinners(cars)
    }
}
