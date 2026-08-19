class Solution {
    private fun decrease(count:MutableMap<Int,Int>,value:Int){
        val next=count[value]!!-1;
        if(next==0)count.remove(value)else count[value]=next
    };
    fun recoverArray(nums:IntArray):IntArray{
        nums.sort();
        val half=nums.size/2;
        for(candidate in 1 until nums.size){
            val gap=nums[candidate]-nums[0];
            if(gap<=0||gap%2==1)continue;
            val count=java.util.TreeMap<Int,Int>();
            for(value in nums)count[value]=(count[value]?:0)+1;
            val answer=IntArray(half);
            var size=0;
            var valid=true;
            for(low in nums){
                if((count[low]?:0)==0)continue;
                val high=low+gap;
                if((count[high]?:0)==0){
                    valid=false;
                    break
                };
                decrease(count,low);
                decrease(count,high);
                answer[size++]=low+gap/2
            };
            if(valid&&size==half)return answer
        };
        return intArrayOf()
    }
}
