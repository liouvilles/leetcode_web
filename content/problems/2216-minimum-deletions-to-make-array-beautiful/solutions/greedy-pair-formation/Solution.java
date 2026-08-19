class Solution {
    public int minDeletion(int[] nums){
        int deletions=0;
        for(int i=0;i+1<nums.length;i++)if((i-deletions)%2==0&&nums[i]==nums[i+1])deletions++;
        if((nums.length-deletions)%2==1)deletions++;
        return deletions;
    }
}
