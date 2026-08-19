class Solution {
    public int sumImbalanceNumbers(int[] nums){
        int answer=0,n=nums.length,maximum=Arrays.stream(nums).max().getAsInt();
        for(int left=0;left<n;left++){
            boolean[] seen=new boolean[maximum+2];
            seen[nums[left]]=true;
            int imbalance=0;
            for(int right=left+1;right<n;right++){
                int value=nums[right];
                if(!seen[value]){
                    imbalance++;
                    if(seen[value-1])imbalance--;
                    if(seen[value+1])imbalance--;
                    seen[value]=true;
                }
                answer+=imbalance;
            }
        }
        return answer;
    }
}
