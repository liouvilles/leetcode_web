class Solution {
    public int waysToSplitArray(int[] nums){
        long total=0,prefix=0;
        for(int value:nums)total+=value;
        int answer=0;
        for(int i=0;i+1<nums.length;i++){
            prefix+=nums[i];
            if(prefix>=total-prefix)answer++;
        }
        return answer;
    }
}
