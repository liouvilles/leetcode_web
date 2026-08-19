class Solution {
    fun superEggDrop(k:Int,n:Int):Int{
        val reachable=LongArray(k+1);
        var moves=0;
        while(reachable[k]<n){
            moves++;
            for(eggs in k downTo 1)reachable[eggs]=reachable[eggs]+reachable[eggs-1]+1
        };
        return moves
    }
}
