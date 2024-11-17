package domain

import domain.Car.CarName

class CarNames(private val values: List<CarName>) {
    init {
        require(values.isNotEmpty()) { "자동차 이름은 하나 이상이어야 합니다." }
        require(values.distinct().size == values.size) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun values(): List<CarName> = values
}
