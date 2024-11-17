package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verify

class RaceTest : BehaviorSpec({
    Given("게임이 진행 중일 때") {
        val cars = mockk<Cars>(relaxed = true)
        val race = Race(cars)
        When("레이스를 진행하면") {
            val actual = race.start()
            Then("자동차들이 움직인다") {
                verify { cars.race() }
            }
            Then("자동차 리스트가 반환된다") {
                actual shouldBe cars
            }
        }
    }
})
