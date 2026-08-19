class Solution {
    public int missingInteger(int[] nums){
        Set<Integer> values=new HashSet<>();
        for(int value:nums)values.add(value);
        int sum=nums[0];
        for(int i=1;i<nums.length&&nums[i]==nums[i-1]+1;i++)sum+=nums[i];
        while(values.contains(sum))sum++;
        return sum;
    }
}
