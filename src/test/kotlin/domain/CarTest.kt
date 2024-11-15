package domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("Car는 shouldMove가 true일 때 전진한다") {
        val car = Car()
        car.move(true)

        car.displayPosition() shouldBe "-"
    }

    test("Car는 shouldMove가 false일 때 멈춘다") {
        val car = Car()
        car.move(false)

        car.displayPosition() shouldBe ""
    }
})
