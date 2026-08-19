class Solution {
    fun unequalTriplets(nums:IntArray):Int{
        nums.sort();
        var answer=0;
        var i=0;
        while(i<nums.size){
            var j=i+1;
            while(j<nums.size&&nums[j]==nums[i])j++;
            answer+=i*(j-i)*(nums.size-j);
            i=j
        };
        return answer
    }
}
