package domain

class CarNames(private val names: List<String>) {
    init {
        require(names.isNotEmpty()) { "자동차 이름은 하나 이상이어야 합니다." }
        require(names.distinct().size == names.size) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun values(): List<String> = names
}
