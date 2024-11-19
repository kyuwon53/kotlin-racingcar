package view

import domain.Cars
import domain.RaceRecord
import domain.Winners

object ResultView {
    fun displayStartMessage() {
        println("\n실행 결과")
    }

    fun displayRoundResults(raceRecord: RaceRecord) {
        raceRecord.raceRecord
            .forEach(::displayRoundResult)
        println() // 각 라운드 간 구분을 위한 빈 줄
    }

    fun displayRoundResult(cars: Cars) {
        cars.getCars()
            .forEach { println("${it.name} : ${displayDistances(it.currentDistance())}") }
        println() // 각 라운드 간 구분을 위한 빈 줄
    }

    fun displayWinners(winners: Winners) {
        val winnerNames = winners.cars().map { it.name }.joinToString(", ")
        println("최종 우승자: $winnerNames")
    }

    private fun displayDistances(distance: Int) = "-".repeat(distance)
}
