package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({
    test("이름 붙인 인자") {
        val actual = Person(name = "홍길동", nickname = "길동", age = 31)

        actual.name shouldBe "홍길동"
        actual.age shouldBe 31
        actual.nickname shouldBe "길동"
    }

    test("널 타입") {
        val actual = Person(name = "홍길동", age = 31, nickname = null)

        actual.name shouldBe "홍길동"
        actual.age shouldBe 31
        actual.nickname shouldBe null
    }

    test("기본 인자") {
        val actual = Person(name = "홍길동", age = 31)

        actual.name shouldBe "홍길동"
        actual.age shouldBe 31
        actual.nickname shouldBe "홍길동"
    }

    test("데이터 클래스") {
        val person1 = Person("홍길동", 31)
        val person2 = Person("홍길동", 31)

        person1.nickname.equals(person2.nickname) shouldBe true
    }
})
