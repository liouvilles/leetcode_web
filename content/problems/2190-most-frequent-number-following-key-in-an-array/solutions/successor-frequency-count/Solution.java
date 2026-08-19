class Solution {
    public int mostFrequent(int[] nums,int key){
        Map<Integer,Integer> frequency=new HashMap<>();
        int answer=0,best=0;
        for(int i=0;i+1<nums.length;i++)if(nums[i]==key){
            int count=frequency.merge(nums[i+1],1,Integer::sum);
            if(count>best){
                best=count;
                answer=nums[i+1];
            }
        }
        return answer;
    }
}
