class Solution {
    fun alternatingSubarray(nums:IntArray):Int{
        var current=1;
        var answer=-1;
        for(i in 1 until nums.size){
            val difference=nums[i]-nums[i-1];
            current=if(current>=2&&difference==if(current%2==0)-1 else 1)current+1 else if(difference==1)2 else 1;
            if(current>=2)answer=maxOf(answer,current)
        };
        return answer
    }
}
