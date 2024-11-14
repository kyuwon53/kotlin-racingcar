package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : BehaviorSpec({
    Given("올바른 수식이 입력된 경우") {
        When("수식이 '3 + 5 * 2 - 4 / 2'일 때") {
            val expression = Expression("3 + 5 * 2 - 4 / 2")
            Then("각 숫자와 연산자가 올바르게 파싱된다") {
                expression.parsedElements[0] shouldBe 3.0
                expression.parsedElements[1] shouldBe Operator.PLUS
                expression.parsedElements[2] shouldBe 5.0
                expression.parsedElements[3] shouldBe Operator.MULTIPLY
                expression.parsedElements[4] shouldBe 2.0
                expression.parsedElements[5] shouldBe Operator.MINUS
                expression.parsedElements[6] shouldBe 4.0
                expression.parsedElements[7] shouldBe Operator.DIVIDE
                expression.parsedElements[8] shouldBe 2.0
            }
        }

        When("getNumber와 getOperator로 각 요소를 불러올 때") {
            val expression = Expression("18 / 2.5 - 3.51")
            Then("각 숫자와 연산자를 올바르게 반환한다") {
                expression.getNumber(0) shouldBe 18.0
                expression.getOperator(1) shouldBe Operator.DIVIDE
                expression.getNumber(2) shouldBe 2.5
                expression.getOperator(3) shouldBe Operator.MINUS
                expression.getNumber(4) shouldBe 3.51
            }
        }
    }

    Given("잘못된 입력이 주어진 경우") {
        When("입력이 빈 공백일 때") {
            Then("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Expression("   ")
                }.message shouldBe "입력값이 빈 공백입니다."

                shouldThrow<IllegalArgumentException> {
                    Expression("")
                }.message shouldBe "입력값이 빈 공백입니다."
            }
        }

        When("마지막에 연산자가 위치할 때") {
            Then("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Expression("9 - 10 /")
                }.message shouldBe "잘못된 입력 형식입니다."
            }
        }

        When("잘못된 연산자나 숫자가 포함된 경우") {
            Then("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Expression("3 + 5 $ 2")
                }.message shouldBe "잘못된 입력 형식입니다."

                shouldThrow<IllegalArgumentException> {
                    Expression("5 + x - 2")
                }.message shouldBe "잘못된 입력 형식입니다."
            }
        }
    }
})
