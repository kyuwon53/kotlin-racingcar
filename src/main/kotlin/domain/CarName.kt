package domain

data class CarName(val value: String) {
    init {
        require(value.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
        require(value.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}
