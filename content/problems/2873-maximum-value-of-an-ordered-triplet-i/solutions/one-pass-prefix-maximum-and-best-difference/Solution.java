class Solution {
    public long maximumTripletValue(int[] nums){
        int maximum=nums[0],difference=0;
        long answer=0;
        for(int k=1;k<nums.length;k++){
            answer=Math.max(answer,(long)difference*nums[k]);
            difference=Math.max(difference,maximum-nums[k]);
            maximum=Math.max(maximum,nums[k]);
        }
        return answer;
    }
}
