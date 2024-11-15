package calculator

class Expression(input: String) {
    val parsedElements: List<Any>

    init {
        require(input.isNotBlank()) { ERROR_INVALID_INPUT }
        parsedElements = parseElements(input.trim())
    }

    private fun parseElements(input: String): List<Any> {
        val sanitizedInput = input.trim().replace("\\s".toRegex(), "") // 모든 공백 제거
        val regex = """(\d+(\.\d+)?|[^\d.\s])""".toRegex() // 숫자 또는 연산자 추출

        val elements =
            regex
                .findAll(sanitizedInput)
                .mapIndexed { index, matchResult ->
                    parseElement(index, matchResult.value)
                }

        require(elements.count() % 2 == 1) { ERROR_INVALID_FORMAT }
        return elements.toList()
    }

    private fun parseNumber(token: String): Double {
        return token.toDoubleOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_FORMAT)
    }

    private fun parseOperator(element: String): Operator {
        return try {
            Operator.fromSymbol(element)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERROR_INVALID_FORMAT)
        }
    }

    private fun parseElement(
        index: Int,
        element: String,
    ): Any {
        return if (index % 2 == 0) parseNumber(element) else parseOperator(element)
    }

    companion object {
        private const val ERROR_INVALID_INPUT = "입력값이 빈 공백입니다."
        private const val ERROR_INVALID_FORMAT = "잘못된 입력 형식입니다."
    }

    fun getNumber(index: Int): Double = parsedElements[index] as Double

    fun getOperator(index: Int): Operator = parsedElements[index] as Operator
}
