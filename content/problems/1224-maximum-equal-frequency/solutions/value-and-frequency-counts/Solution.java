class Solution {
    public int maxEqualFreq(int[] nums){
        Map<Integer,Integer> valueCount=new HashMap<>(),frequencyCount=new HashMap<>();
        int maximum=0,answer=0;
        for(int i=0;i<nums.length;i++){
            int old=valueCount.getOrDefault(nums[i],0);
            if(old>0)frequencyCount.put(old,frequencyCount.get(old)-1);
            int current=old+1;
            valueCount.put(nums[i],current);
            frequencyCount.put(current,frequencyCount.getOrDefault(current,0)+1);
            maximum=Math.max(maximum,current);
            int length=i+1;
            if(maximum==1||maximum*frequencyCount.getOrDefault(maximum,0)+1==length||(maximum-1)*(frequencyCount.getOrDefault(maximum-1,0)+1)+1==length)answer=length;
        }
        return answer;
    }
}
