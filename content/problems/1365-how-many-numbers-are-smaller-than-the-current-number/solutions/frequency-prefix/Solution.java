class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums){
        int[] count=new int[101];
        for(int value:nums)count[value]++;
        int smaller=0;
        for(int value=0;value<=100;value++){
            int frequency=count[value];
            count[value]=smaller;
            smaller+=frequency;
        }
        for(int i=0;i<nums.length;i++)nums[i]=count[nums[i]];
        return nums;
    }
}
