class Solution {
    public boolean checkSubarraySum(int[] nums,int k){
        Map<Long,Integer> first=new HashMap<>();
        first.put(0L,-1);
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            long key=k==0?sum:sum%k;
            Integer previous=first.get(key);
            if(previous!=null){
                if(i-previous>=2)return true;
            }else first.put(key,i);
        }
        return false;
    }
}
