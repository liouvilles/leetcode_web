class Solution {
    public boolean findSubarrays(int[] nums){
        Set<Integer> seen=new HashSet<>();
        for(int i=1;i<nums.length;i++)if(!seen.add(nums[i-1]+nums[i]))return true;
        return false;
    }
}
