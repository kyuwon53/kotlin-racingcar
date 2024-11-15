package domain

fun interface MoveDecision {
    fun shouldMove(): Boolean
}

class RandomMoveDecision : MoveDecision {
    override fun shouldMove(): Boolean = (0..9).random() >= 4
}
