class Solution {
    fun goodDaysToRobBank(security:IntArray,time:Int):List<Int>{
        val n=security.size;
        val left=IntArray(n);
        val right=IntArray(n);
        for(i in 1 until n)if(security[i]<=security[i-1])left[i]=left[i-1]+1;
        for(i in n-2 downTo 0)if(security[i]<=security[i+1])right[i]=right[i+1]+1;
        return security.indices.filter{
            left[it]>=time&&right[it]>=time
        }
    }
}
