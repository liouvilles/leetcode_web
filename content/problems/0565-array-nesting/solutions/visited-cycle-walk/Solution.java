class Solution {
    public int arrayNesting(int[] nums){
        boolean[] visited=new boolean[nums.length];
        int best=0;
        for(int start=0;start<nums.length;start++)if(!visited[start]){
            int length=0,current=start;
            while(!visited[current]){
                visited[current]=true;
                current=nums[current];
                length++;
            }
            best=Math.max(best,length);
        }
        return best;
    }
}
