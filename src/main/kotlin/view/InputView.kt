package view

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수를 입력해주세요:")

        val input = readln().toIntOrNull()
        if (input == null || input <= 0) {
            println("올바른 숫자를 입력해주세요.")
            return getCarCount()
        }
        return input
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
}
