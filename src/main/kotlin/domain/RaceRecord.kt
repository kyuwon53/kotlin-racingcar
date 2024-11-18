package domain

class RaceRecord(raceRecord: List<Cars> = emptyList()) {
    private val _raceRecord = raceRecord.toMutableList()
    val raceRecord: List<Cars> get() = _raceRecord

    fun record(cars: Cars) {
        _raceRecord.add(cars)
    }
}
