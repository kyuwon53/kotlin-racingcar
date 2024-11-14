package calculator

class StringCalculator

fun calculate(input: String?): Double {
    val expression = Expression(input)
    return expression.parsedElements
        .drop(1)
        .fold(expression.getNumber(0)) { acc, element ->
            when (element) {
                is Operator -> {
                    val nextIndex = expression.parsedElements.indexOf(element) + 1
                    val nextNumber = expression.getNumber(nextIndex)
                    element.calculate(acc, nextNumber)
                }

                else -> acc
            }
        }
}
