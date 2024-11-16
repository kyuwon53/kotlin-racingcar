package view

import domain.CarName
import domain.CarNames

object InputView {
    fun getCarNames(): CarNames {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")

        val input = readln()
        val carNames = processInput(input)

        return try {
            CarNames(carNames.map { CarName(it) })
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getCarNames() // 재귀 호출로 다시 입력 요청
        }
    }

    fun getRounds(): Int {
        println("시도할 회수는 몇 회인가요?")

        val input = readln().toIntOrNull()
        if (input == null || input <= 0) {
            println("올바른 숫자를 입력해주세요.")
            return getRounds()
        }
        return input
    }

    private fun processInput(input: String): List<String> {
        return input.split(",").map { it.trim() }
    }
}
