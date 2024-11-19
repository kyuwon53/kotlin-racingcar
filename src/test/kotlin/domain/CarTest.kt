package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
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

        Then("초기 거리는 0이다") {
            car.currentDistance() shouldBe 0
        }

        When("이동 조건이 충족되면") {
            car.move(true)

            Then("자동차는 한 칸 전진한다") {
                car.currentDistance() shouldBe 1
            }
        }

        When("이동 조건이 충족되지 않으면") {
            car.move(false)

            Then("자동차는 멈춘다") {
                car.currentDistance() shouldBe 0
            }
        }

        When("이동 조건이 여러 번 충족되면") {
            car.move(true)
            car.move(true)

            Then("거리는 충족된 횟수만큼 증가한다") {
                car.currentDistance() shouldBe 2
            }
        }
    }
})
