package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinnersTest : BehaviorSpec({

    Given("여러 자동차가 있을 때") {
        val car1 = Car(Car.CarName("Benz"), 5)
        val car2 = Car(Car.CarName("Audi"), 5)
        val car3 = Car(Car.CarName("Ford"), 3)

        val cars = Cars(listOf(car1, car2, car3))

        When("우승자를 판별하면") {
            val winners = Winners(cars)
            val result = winners.determine()

            Then("가장 멀리 이동한 자동차들이 반환된다") {
                result.cars() shouldBe listOf(car1, car2)
            }
        }
    }

    Given("자동차 리스트가 비어 있을 때") {
        val cars = Cars(emptyList())

        When("우승자를 판별하면") {
            val winners = Winners(cars)
            val result = winners.determine()

            Then("빈 리스트가 반환된다") {
                result.cars() shouldBe emptyList()
            }
        }
    }
})
