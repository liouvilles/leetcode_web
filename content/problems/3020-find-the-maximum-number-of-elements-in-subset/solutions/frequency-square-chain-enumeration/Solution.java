class Solution {
    public int maximumLength(int[] nums){
        Map<Long,Integer> frequency=new HashMap<>();
        for(int value:nums)frequency.merge((long)value,1,Integer::sum);
        int answer=1,ones=frequency.getOrDefault(1L,0);
        if(ones>0)answer=(ones&1)==1?ones:ones-1;
        for(long start:frequency.keySet()){
            if(start==1)continue;
            int length=0;
            long value=start;
            while(frequency.getOrDefault(value,0)>=2){
                length+=2;
                value*=value;
            }
            length+=frequency.getOrDefault(value,0)>0?1:-1;
            answer=Math.max(answer,length);
        }
        return answer;
    }
}
