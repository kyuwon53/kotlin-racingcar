package domain

class CarNames(private val names: Set<String>) {
    init {
        require(names.isNotEmpty()) { "자동차 이름은 하나 이상이어야 합니다." }
    }

    fun values(): List<String> = names.toList()
}
