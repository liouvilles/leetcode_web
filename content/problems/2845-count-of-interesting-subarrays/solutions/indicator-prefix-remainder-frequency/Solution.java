class Solution {
    public long countInterestingSubarrays(List<Integer> nums,int modulo,int k){
        Map<Integer,Long> frequency=new HashMap<>();
        frequency.put(0,1L);
        int prefix=0;
        long answer=0;
        for(int value:nums){
            if(value%modulo==k)prefix++;
            int remainder=prefix%modulo,needed=(remainder-k+modulo)%modulo;
            answer+=frequency.getOrDefault(needed,0L);
            frequency.put(remainder,frequency.getOrDefault(remainder,0L)+1);
        }
        return answer;
    }
}
