package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarNamesTest : FunSpec({
    test("이름 리스트가 비어 있으면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            CarNames(emptyList())
        }.message shouldBe "자동차 이름은 하나 이상이어야 합니다."
    }

    test("이름 리스트에 중복이 있으면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            CarNames(listOf(CarName("Benz"), CarName("Benz")))
        }.message shouldBe "자동차 이름은 중복될 수 없습니다."
    }

    test("정상적인 이름 리스트로 CarNames 객체를 생성할 수 있다") {
        val carNames = CarNames(listOf(CarName("Benz"), CarName("Audi")))
        carNames.names() shouldBe listOf("Benz", "Audi")
    }
})
