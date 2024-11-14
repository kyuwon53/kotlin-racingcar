package view

import domain.Cars

object ResultView {
    fun displayStartMessage() {
        println("\n실행 결과")
    }

    fun displayRoundResults(cars: Cars) {
        cars.displayPositions().forEach { println(it) }
        println() // 각 라운드 간 구분을 위한 빈 줄
    }
}
