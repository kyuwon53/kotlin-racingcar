package app

import controller.RaceGame
import domain.RandomMoveDecision
import view.InputView
import view.ResultView

fun main() {
    val carNames = InputView.getCarNames()
    val rounds = InputView.getRounds()
    val moveDecision = RandomMoveDecision() // 실제 게임에서는 무작위 결정 사용

    val raceGame = RaceGame(carNames, rounds, moveDecision)

    ResultView.displayStartMessage()
    raceGame.start()
    ResultView.displayWinners(raceGame.winners())
}
