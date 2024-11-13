package calculator

enum class Operator(
    val symbol: String,
    val operation: (Double, Double) -> Double,
) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 ->
        require(num2 != 0.0) { "0으로 나눌 수 없습니다." }
        num1 / num2
    }),
    ;

    fun apply(
        num1: Double,
        num2: Double,
    ): Double = operation(num1, num2)
}
