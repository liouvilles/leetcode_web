class Solution {
    public List<Integer> maxScoreIndices(int[] nums){
        int score=0;
        for(int value:nums)score+=value;
        int maximum=-1;
        List<Integer> answer=new ArrayList<>();
        for(int split=0;split<=nums.length;split++){
            if(score>maximum){
                maximum=score;
                answer.clear();
                answer.add(split);
            }else if(score==maximum)answer.add(split);
            if(split<nums.length)score+=nums[split]==0?1:-1;
        }
        return answer;
    }
}
