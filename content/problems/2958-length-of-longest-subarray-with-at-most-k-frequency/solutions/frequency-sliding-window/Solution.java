class Solution {
    public int maxSubarrayLength(int[] nums,int k){
        Map<Integer,Integer> frequency=new HashMap<>();
        int left=0,answer=0;
        for(int right=0;right<nums.length;right++){
            frequency.merge(nums[right],1,Integer::sum);
            while(frequency.get(nums[right])>k){
                frequency.put(nums[left],frequency.get(nums[left])-1);
                left++;
            }
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
