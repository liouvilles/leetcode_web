class Solution {
    public int countSubarrays(int[] nums,int k){
        int pivot=0;
        while(nums[pivot]!=k)pivot++;
        Map<Integer,Integer> frequency=new HashMap<>();
        frequency.put(0,1);
        int balance=0;
        for(int i=pivot-1;i>=0;i--){
            balance+=nums[i]>k?1:-1;
            frequency.merge(balance,1,Integer::sum);
        }
        long answer=0;
        balance=0;
        for(int i=pivot;i<nums.length;i++){
            if(i>pivot)balance+=nums[i]>k?1:-1;
            answer+=frequency.getOrDefault(-balance,0)+frequency.getOrDefault(1-balance,0);
        }
        return (int)answer;
    }
}
