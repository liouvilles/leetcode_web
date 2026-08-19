class Solution {
    public int minLengthAfterRemovals(List<Integer> nums){
        Map<Integer,Integer> frequency=new HashMap<>();
        int maximumFrequency=0;
        for(int value:nums){
            int count=frequency.getOrDefault(value,0)+1;
            frequency.put(value,count);
            maximumFrequency=Math.max(maximumFrequency,count);
        }
        return Math.max(2*maximumFrequency-nums.size(),nums.size()%2);
    }
}
