class Solution {
    public int minimizeArrayValue(int[] nums){
        long prefix=0;
        int answer=0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            answer=Math.max(answer,(int)((prefix+i)/(i+1)));
        }
        return answer;
    }
}
