class Solution {
    public int missingNumber(int[] nums){
        int answer=nums.length;
        for(int i=0;i<nums.length;i++)answer^=i^nums[i];
        return answer;
    }
}
