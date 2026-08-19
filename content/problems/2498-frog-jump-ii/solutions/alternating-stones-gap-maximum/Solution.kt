class Solution {
    fun maxJump(stones:IntArray):Int{
        if(stones.size==2)return stones[1]-stones[0];
        var answer=stones[1]-stones[0];
        for(i in 2 until stones.size)answer=maxOf(answer,stones[i]-stones[i-2]);
        return answer
    }
}
