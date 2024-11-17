package domain

import domain.Car.CarName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    test("자동차의 이름은 생성 시 주어진다") {
        val car = Car(CarName("benz"))
        car.name.value shouldBe "benz"
    }

    test("자동차는 전진 조건을 충족하면 한 칸 전진한다") {
        val car = Car(CarName("benz"))
        car.move(true)

        car.currentDistance() shouldBe 1
    }

    test("자동차는 전진 조건을 충족하지 않으면 멈춘다") {
        val car = Car(CarName("benz"))
        car.move(false)

        car.currentDistance() shouldBe 0
    }
})
