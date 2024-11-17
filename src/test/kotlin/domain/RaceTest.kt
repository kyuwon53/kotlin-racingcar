package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
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

    Given("게임이 끝난 후") {
        val cars = mockk<Cars>(relaxed = true)
        val race = Race(cars)
        val winners = mockk<Winners>()
        val raceJudge = mockk<RaceJudge>()

        every { raceJudge.findWinners(cars) } returns winners

        When("우승자를 확인하면") {
            val result = race.getWinners()

            Then("우승자를 반환한다") {
                result shouldBe winners
            }
        }
    }
})
