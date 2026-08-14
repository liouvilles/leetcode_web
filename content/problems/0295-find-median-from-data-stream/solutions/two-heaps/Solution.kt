class MedianFinder {
    private val lower = PriorityQueue<Int>(compareByDescending { it })
    private val upper = PriorityQueue<Int>()
    fun addNum(num: Int) { lower.add(num); upper.add(lower.remove()); if (upper.size > lower.size) lower.add(upper.remove()) }
    fun findMedian(): Double = if (lower.size > upper.size) lower.element().toDouble() else (lower.element().toLong() + upper.element()) / 2.0
}
