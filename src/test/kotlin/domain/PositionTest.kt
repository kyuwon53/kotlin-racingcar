import domain.Position
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PositionTest : BehaviorSpec({

    Given("Position이 초기화된 상태에서") {
        var position = Position()
        afterTest {
            position = Position()
        }

        Then("거리는 0이다") {
            position.distance() shouldBe 0
        }

        When("이동 조건이 충족되면") {
            position.move(true)

            Then("거리는 1 증가한다") {
                position.distance() shouldBe 1
            }
        }

        When("이동 조건이 충족되지 않으면") {
            position.move(false)

            Then("거리는 유지된다") {
                position.distance() shouldBe 0
            }
        }

        When("이동 조건이 여러 번 충족되면") {
            position.move(true)
            position.move(true)

            Then("거리는 충족된 횟수만큼 증가한다") {
                position.distance() shouldBe 2
            }
        }
    }
})
