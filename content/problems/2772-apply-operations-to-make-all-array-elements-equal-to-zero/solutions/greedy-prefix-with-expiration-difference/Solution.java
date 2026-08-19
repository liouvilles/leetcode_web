class Solution {
    public boolean checkArray(int[] nums,int k){
        long[] expire=new long[nums.length+1];
        long active=0;
        for(int i=0;i<nums.length;i++){
            active-=expire[i];
            long needed=nums[i]-active;
            if(needed<0)return false;
            if(needed>0){
                if(i+k>nums.length)return false;
                active+=needed;
                expire[i+k]+=needed;
            }
        }
        return true;
    }
}
