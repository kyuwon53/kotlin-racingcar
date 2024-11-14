import domain.Position
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PositionTest : FunSpec({
    test("display 함수는 현재 거리에 따라 '-' 문자를 반복하여 표시한다") {
        val position = Position()
        repeat(3) { position.moveForward() }
        position.display() shouldBe "---"
    }

    test("Position 객체는 기본 생성 시 거리가 0으로 설정된다") {
        val position = Position()
        position.display() shouldBe ""
    }

    test("moveForward 함수 호출 시 거리가 1씩 증가한다") {
        val position = Position()
        position.moveForward()
        position.display() shouldBe "-"

        position.moveForward()
        position.display() shouldBe "--"
    }
})
