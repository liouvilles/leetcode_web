class Solution {
    fun minimumDifference(nums:IntArray):Int{
        val n=nums.size/2;
        val left=Array(n+1){
            mutableListOf<Long>()
        };
        val right=Array(n+1){
            mutableListOf<Long>()
        };
        val total=nums.sumOf{
            it.toLong()
        };
        for(mask in 0 until (1 shl n)){
            var a=0L;
            var b=0L;
            val count=Integer.bitCount(mask);
            for(bit in 0 until n)if(mask and (1 shl bit)!=0){
                a+=nums[bit];
                b+=nums[n+bit]
            };
            left[count].add(a);
            right[count].add(b)
        };
        right.forEach{
            it.sort()
        };
        var answer=Long.MAX_VALUE;
        for(count in 0..n)for(a in left[count]){
            val values=right[n-count];
            val target=total/2-a;
            var index=values.binarySearch(target);
            if(index<0)index=-index-1;
            for(position in maxOf(0,index-1)..minOf(values.lastIndex,index+1))answer=minOf(answer,kotlin.math.abs(total-2*(a+values[position])))
        };
        return answer.toInt()
    }
}
