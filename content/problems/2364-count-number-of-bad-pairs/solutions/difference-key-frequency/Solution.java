class Solution {
    public long countBadPairs(int[] nums){
        Map<Integer,Integer> frequency=new HashMap<>();
        long answer=0;
        for(int index=0;index<nums.length;index++){
            int key=nums[index]-index;
            answer+=index-frequency.getOrDefault(key,0);
            frequency.merge(key,1,Integer::sum);
        }
        return answer;
    }
}
