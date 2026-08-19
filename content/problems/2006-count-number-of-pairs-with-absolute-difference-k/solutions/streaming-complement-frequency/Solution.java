class Solution {
    public int countKDifference(int[] nums,int k){
        Map<Integer,Integer> frequency=new HashMap<>();
        int answer=0;
        for(int value:nums){
            answer+=frequency.getOrDefault(value-k,0)+frequency.getOrDefault(value+k,0);
            frequency.merge(value,1,Integer::sum);
        }
        return answer;
    }
}
