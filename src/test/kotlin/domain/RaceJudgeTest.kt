package domain

import domain.Car.CarName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RaceJudgeTest : BehaviorSpec({

    Given("여러 자동차가 있을 때") {
        val car1 = Car(CarName("Benz"), 5)
        val car2 = Car(CarName("Audi"), 5)
        val car3 = Car(CarName("Ford"), 3)

        val cars = Cars(listOf(car1, car2, car3), { true })
        val judge = RaceJudge()

        When("우승자를 판별하면") {
            val winners = judge.findWinners(cars)

            Then("가장 멀리 이동한 자동차들이 반환된다") {
                winners.winners shouldBe listOf(car1, car2)
            }
        }
    }

    Given("자동차 리스트가 비어 있을 때") {
        val cars = Cars(emptyList(), { true })
        val judge = RaceJudge()

        When("우승자를 판별하면") {
            val winners = judge.findWinners(cars)

            Then("빈 리스트가 반환된다") {
                winners.winners shouldBe emptyList()
            }
        }
    }
})
