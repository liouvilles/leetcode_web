class Solution {
    public long minCost(int[] nums,int[] cost){
        Integer[] order=new Integer[nums.length];
        long total=0;
        for(int i=0;i<nums.length;i++){
            order[i]=i;
            total+=cost[i];
        }
        Arrays.sort(order,Comparator.comparingInt(i->nums[i]));
        long cumulative=0;
        int target=0;
        for(int index:order){
            cumulative+=cost[index];
            if(cumulative*2>=total){
                target=nums[index];
                break;
            }
        }
        long answer=0;
        for(int i=0;i<nums.length;i++)answer+=Math.abs((long)nums[i]-target)*cost[i];
        return answer;
    }
}
