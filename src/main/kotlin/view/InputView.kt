package view

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수를 입력해주세요:")

        return readLine()?.toIntOrNull()?.takeIf { it > 0 }
            ?: run {
                println("올바른 숫자를 입력해주세요.")
                getCarCount()
            }
    }

    fun getRounds(): Int {
        println("시도할 회수는 몇 회인가요?")

        return readLine()?.toIntOrNull()?.takeIf { it > 0 }
            ?: run {
                println("올바른 숫자를 입력해주세요.")
                getRounds()
            }
    }
}
