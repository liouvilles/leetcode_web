class Solution {
    public int maxSumRangeQuery(int[] nums,int[][] requests){
        int n=nums.length;
        int[] frequency=new int[n+1];
        for(int[] request:requests){
            frequency[request[0]]++;
            frequency[request[1]+1]--;
        }
        for(int i=1;i<n;i++)frequency[i]+=frequency[i-1];
        Arrays.sort(nums);
        Arrays.sort(frequency,0,n);
        long answer=0;
        for(int i=0;i<n;i++)answer=(answer+(long)nums[i]*frequency[i])%1_000_000_007L;
        return (int)answer;
    }
}
