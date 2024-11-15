package domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("자동차는 전진 조건을 충족하면 한 칸 전진한다") {
        val car = Car()
        car.move(true)

        car.currentDistance() shouldBe 1
    }

    test("자동차는 전진 조건을 충족하지 않으면 멈춘다") {
        val car = Car()
        car.move(false)

        car.currentDistance() shouldBe 0
    }
})
