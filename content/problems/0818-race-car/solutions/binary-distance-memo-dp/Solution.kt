class Solution {
    private val memo=mutableMapOf<Int,Int>();
    fun racecar(target:Int):Int{
        memo[target]?.let{
            return it
        };
        val n=32-Integer.numberOfLeadingZeros(target);
        if((1 shl n)-1==target)return n;
        var answer=n+1+racecar((1 shl n)-1-target);
        val forward=(1 shl(n-1))-1;
        for(m in 0 until n-1){
            val backward=(1 shl m)-1;
            answer=minOf(answer,n+m+1+racecar(target-forward+backward))
        };
        memo[target]=answer;
        return answer
    }
}
