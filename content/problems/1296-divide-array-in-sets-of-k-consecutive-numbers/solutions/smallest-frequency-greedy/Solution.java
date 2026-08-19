class Solution {
    public boolean isPossibleDivide(int[] nums,int k){
        if(nums.length%k!=0)return false;
        TreeMap<Integer,Integer> frequency=new TreeMap<>();
        for(int value:nums)frequency.merge(value,1,Integer::sum);
        while(!frequency.isEmpty()){
            int start=frequency.firstKey();
            for(int value=start;value<start+k;value++){
                Integer count=frequency.get(value);
                if(count==null)return false;
                if(count==1)frequency.remove(value);
                else frequency.put(value,count-1);
            }
        }
        return true;
    }
}
