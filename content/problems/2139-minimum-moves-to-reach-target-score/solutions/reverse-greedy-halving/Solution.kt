class Solution {
    fun minMoves(targetValue:Int,maxDoublesValue:Int):Int{
        var target=targetValue;
        var maxDoubles=maxDoublesValue;
        var moves=0;
        while(target>1&&maxDoubles>0){
            if(target%2==0){
                target/=2;
                maxDoubles--
            }else target--;
            moves++
        };
        return moves+target-1
    }
}
