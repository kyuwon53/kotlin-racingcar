package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

private class FixedMoveDecision(private val shouldMove: Boolean) : MoveDecision {
    override fun shouldMove(): Boolean = shouldMove
}

class CarsTest : BehaviorSpec({

    Given("여러 대의 자동차가 있고") {
        val car1 = Car()
        val car2 = Car()
        val car3 = Car()

        When("모든 자동차가 전진하도록 결정된 경우") {
            val cars = Cars(listOf(car1, car2, car3), FixedMoveDecision(true))
            cars.race()

            Then("모든 자동차는 한 칸 전진한다") {
                cars.displayPositions() shouldBe listOf("-", "-", "-")
            }
        }

        When("모든 자동차가 멈추도록 결정된 경우") {
            val cars = Cars(listOf(car1, car2, car3), FixedMoveDecision(false))
            cars.race()

            Then("모든 자동차는 위치를 유지한다") {
                cars.displayPositions() shouldBe listOf("-", "-", "-") // 이미 전진한 상태에서 멈춤
            }
        }
    }
})
