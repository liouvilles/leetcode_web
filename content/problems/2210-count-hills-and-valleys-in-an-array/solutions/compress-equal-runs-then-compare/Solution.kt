class Solution {
    fun countHillValley(nums:IntArray):Int{
        val values=mutableListOf<Int>();
        for(value in nums)if(values.isEmpty()||values.last()!=value)values.add(value);
        var answer=0;
        for(i in 1 until values.lastIndex)if(values[i]>values[i-1]&&values[i]>values[i+1]||values[i]<values[i-1]&&values[i]<values[i+1])answer++;
        return answer
    }
}
