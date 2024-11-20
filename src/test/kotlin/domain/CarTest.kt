package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    Given("두 자동차가 주어졌을 때") {
        val car1 = Car("Car1", 5)
        val car2 = Car("Car2", 3)

        When("첫 번째 자동차가 두 번째 자동차보다 멀리 있을 때") {
            Then("첫 번째 자동차가 더 멀리 있다고 판단한다") {
                car1.compareTo(car2) shouldBeGreaterThan 0
            }

            Then("두 번째 자동차는 더 멀리 있지 않다고 판단한다") {
                car2.compareTo(car1) shouldBeLessThan 0
            }
        }

        When("두 자동차가 같은 위치에 있을 때") {
            val car3 = Car("Car3", 5)

            Then("두 자동차가 같은 위치에 있다고 판단한다") {
                car1.compareTo(car3) shouldBeEqualComparingTo 0
            }
        }
    }

    Given("자동차 이름을 생성할 때") {

        When("이름이 공백이면") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Car(" ")
                }.message shouldBe "자동차 이름은 공백일 수 없습니다."
            }
        }

        When("이름이 5자를 초과하면") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Car("Ferrari")
                }.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
            }
        }

        When("정상적인 이름이 주어지면") {
            Then("CarName 객체를 생성할 수 있다") {
                val car = Car("Benz")
                car.name shouldBe "Benz"
            }
        }
    }

    Given("자동차가 정상적으로 생성되었을 때") {
        var car = Car("benz")

        beforeContainer {
            car = Car("benz")
        }

        Then("초기 위치는 0이다") {
            car.position shouldBe 0
        }

        When("이동 조건이 충족되면") {
            car.move(true)

            Then("자동차는 한 칸 전진한다") {
                car.position shouldBe 1
            }
        }

        When("이동 조건이 충족되지 않으면") {
            car.move(false)

            Then("자동차는 멈춘다") {
                car.position shouldBe 0
            }
        }

        When("이동 조건이 여러 번 충족되면") {
            car.move(true)
            car.move(true)

            Then("위치는 충족된 횟수만큼 증가한다") {
                car.position shouldBe 2
            }
        }
    }
})
