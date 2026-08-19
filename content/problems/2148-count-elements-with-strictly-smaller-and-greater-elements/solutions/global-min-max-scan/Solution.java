class Solution {
    public int countElements(int[] nums){
        int minimum=Arrays.stream(nums).min().getAsInt(),maximum=Arrays.stream(nums).max().getAsInt(),answer=0;
        for(int value:nums)if(value>minimum&&value<maximum)answer++;
        return answer;
    }
}
