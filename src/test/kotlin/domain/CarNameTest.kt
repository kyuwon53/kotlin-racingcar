package domain

import domain.Car.CarName
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarNameTest : FunSpec({
    test("이름이 공백이면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            CarName(" ")
        }.message shouldBe "자동차 이름은 공백일 수 없습니다."
    }

    test("이름이 5자를 초과하면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            CarName("Ferrari")
        }.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
    }

    test("정상적인 이름으로 CarName 객체를 생성할 수 있다") {
        val carName = CarName("Benz")
        carName.value shouldBe "Benz"
    }
})
