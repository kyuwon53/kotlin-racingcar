package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : BehaviorSpec({
    Given("간단한 연산식을 입력받았을 때") {
        val inputs =
            listOf(
                "1 + 2" to 3.0,
                "1 - 2" to -1.0,
                "1 * 2" to 2.0,
                "1 / 2" to 0.5,
                "1.5 + 2.5" to 4.0,
                "1.5 - 2.5" to -1.0,
                "1.5 * 2.5" to 3.75,
                "1.5 / 2.5" to 0.6,
                "12+4" to 16.0,
                "1.2-3.4" to -2.2,
                "1.4*0" to 0.0,
            )
        When("calculate 함수를 호출하면") {
            inputs.forEach { (input, expected) ->
                val result = calculate(input)
                Then("연산 결과를 반환한다") {
                    result shouldBe expected
                }
            }
        }
    }

    Given("여러 연산이 포함된 복잡한 연산식을 입력받았을 때") {
        val input =
            listOf(
                "1 + 2" to 3.0,
                "10 - 4" to 6.0,
                "4 * 5" to 20.0,
                "20 / 5" to 4.0,
                "2 + 3 * 4 - 5 / 5" to 3.0,
                "10 + 5 - 3" to 12.0,
                "4 * 5 / 2" to 10.0,
                "11 + 13 * 3 / 4" to 18.0,
            )
        When("calculate 함수를 호출하면") {
            input.forEach { (input, expected) ->
                val result = calculate(input)
                Then("순서대로 연산한 결과를 반환한다") {
                    result shouldBe expected
                }
            }
        }
    }

    Given("잘못된 형식의 입력값을 받았을 때") {
        val invalidExpressions =
            listOf(
                "5 +" to "잘못된 입력 형식입니다.",
                "5 10 /" to "잘못된 입력 형식입니다.",
                "- 10 /" to "잘못된 입력 형식입니다.",
                "- 10 / 5" to "잘못된 입력 형식입니다.",
                "" to "입력값이 null이거나 빈 공백입니다.",
                null to "입력값이 null이거나 빈 공백입니다.",
            )
        When("calculate 함수를 호출하면") {
            invalidExpressions.forEach { (input, expected) ->
                Then("잘못된 입력 형식 예외가 발생한다") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            calculate(input)
                        }
                    exception.message shouldBe expected
                }
            }
        }
    }

    Given("0으로 나누는 연산식을 입력받았을 때") {
        val input = "10 / 0"
        When("calculate 함수를 호출하면") {
            Then("0으로 나눌 수 없다는 예외가 발생한다") {
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculate(input)
                    }
                exception.message shouldBe "0으로 나눌 수 없습니다."
            }
        }
    }
})
