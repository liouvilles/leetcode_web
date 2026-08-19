class Solution {
    public int maximizeGreatness(int[] nums){
        Arrays.sort(nums);
        int small=0,answer=0;
        for(int large=0;large<nums.length;large++)if(nums[large]>nums[small]){
            small++;
            answer++;
        }
        return answer;
    }
}
