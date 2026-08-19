class Solution {
    public long countAlternatingSubarrays(int[] nums){
        long answer=1,ending=1;
        for(int index=1;index<nums.length;index++){
            ending=nums[index]!=nums[index-1]?ending+1:1;
            answer+=ending;
        }
        return answer;
    }
}
