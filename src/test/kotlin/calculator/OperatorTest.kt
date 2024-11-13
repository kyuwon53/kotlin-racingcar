package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "PLUS 연산 테스트" {
        Operator.PLUS.apply(10.0, 5.0) shouldBe 15.0
    }

    "MINUS 연산 테스트" {
        Operator.MINUS.apply(10.0, 5.0) shouldBe 5.0
    }

    "MULTIPLY 연산 테스트" {
        Operator.MULTIPLY.apply(10.0, 5.0) shouldBe 50.0
    }

    "DIVIDE 연산 테스트" {
        Operator.DIVIDE.apply(10.0, 2.0) shouldBe 5.0
    }

    "DIVIDE 연산에서 0으로 나누기 시 예외 발생 테스트" {
        shouldThrow<IllegalArgumentException> {
            Operator.DIVIDE.apply(10.0, 0.0)
        }.message shouldBe "0으로 나눌 수 없습니다."
    }
})
