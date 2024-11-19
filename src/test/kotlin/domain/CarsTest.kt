package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    Given("여러 대의 자동차가 있고") {
        val car1 = Car("matiz")
        val car2 = Car("benz")
        val car3 = Car("audi")

        When("모든 자동차가 전진하도록 결정된 경우") {
            val cars = Cars(listOf(car1, car2, car3)) { true }
            cars.race()

            Then("모든 자동차는 한 칸 전진한다") {
                cars.getCars().map { it.currentDistance() } shouldBe listOf(1, 1, 1)
            }
        }

        When("모든 자동차가 멈추도록 결정된 경우") {
            val cars = Cars(listOf(car1, car2, car3)) { false }
            cars.race()

            Then("모든 자동차는 위치를 유지한다") {
                cars.getCars().map { it.currentDistance() } shouldBe listOf(1, 1, 1) // 이미 전진한 상태에서 멈춤
            }
        }
    }
})
