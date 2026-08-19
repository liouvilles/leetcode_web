class Solution {
    public int subarraysWithKDistinct(int[] nums,int k){
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums,int limit){
        Map<Integer,Integer> frequency=new HashMap<>();
        int left=0,distinct=0,count=0;
        for(int right=0;right<nums.length;right++){
            if(frequency.getOrDefault(nums[right],0)==0)distinct++;
            frequency.merge(nums[right],1,Integer::sum);
            while(distinct>limit){
                int value=nums[left++];
                frequency.put(value,frequency.get(value)-1);
                if(frequency.get(value)==0)distinct--;
            }
            count+=right-left+1;
        }
        return count;
    }
}
