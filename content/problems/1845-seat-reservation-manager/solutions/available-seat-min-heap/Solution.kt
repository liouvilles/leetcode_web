class SeatManager(n:Int) {
    private val available=java.util.PriorityQueue<Int>();
    init{
        for(seat in 1..n)available.add(seat)
    };
    fun reserve():Int=available.remove();
    fun unreserve(seatNumber:Int){
        available.add(seatNumber)
    }
}
