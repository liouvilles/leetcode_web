class Solution {
    public List<Integer> minSubsequence(int[] nums){
        Arrays.sort(nums);
        int total=Arrays.stream(nums).sum(),selected=0;
        List<Integer> answer=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            answer.add(nums[i]);
            selected+=nums[i];
            if(selected>total-selected)break;
        }
        return answer;
    }
}
