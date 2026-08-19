class Solution {
    fun lastStoneWeightII(stones:IntArray):Int{
        val total=stones.sum();
        val capacity=total/2;
        val possible=BooleanArray(capacity+1);
        possible[0]=true;
        for(stone in stones)for(sum in capacity downTo stone)possible[sum]=possible[sum]||possible[sum-stone];
        for(sum in capacity downTo 0)if(possible[sum])return total-2*sum;
        return total
    }
}
