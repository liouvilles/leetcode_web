class Solution {
    fun countMatchingSubarrays(nums:IntArray,pattern:IntArray):Int{
        var answer=0;
        for(start in 0 until nums.size-pattern.size){
            var matches=true;
            for(index in pattern.indices)if(nums[start+index+1].compareTo(nums[start+index])!=pattern[index]){
                matches=false;
                break
            };
            if(matches)answer++
        };
        return answer
    }
}
