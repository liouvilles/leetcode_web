class Solution {
    fun corpFlightBookings(bookings:Array<IntArray>,n:Int):IntArray{
        val difference=IntArray(n+1);
        for(booking in bookings){
            difference[booking[0]-1]+=booking[2];
            difference[booking[1]]-=booking[2]
        };
        val answer=IntArray(n);
        var running=0;
        for(i in 0 until n){
            running+=difference[i];
            answer[i]=running
        };
        return answer
    }
}
