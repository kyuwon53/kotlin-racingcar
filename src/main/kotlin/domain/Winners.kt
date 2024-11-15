package domain

class Winners(val winners: List<Car>) {
    fun names(): List<String> = winners.map { it.name.value }
}
