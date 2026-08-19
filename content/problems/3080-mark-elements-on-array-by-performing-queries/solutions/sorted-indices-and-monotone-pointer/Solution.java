class Solution {
    public long[] unmarkedSumArray(int[] nums,int[][] queries){
        int n=nums.length;
        long remaining=0;
        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++){
            remaining+=nums[i];
            order[i]=i;
        }
        Arrays.sort(order,(a,b)->nums[a]!=nums[b]?Integer.compare(nums[a],nums[b]):Integer.compare(a,b));
        boolean[] marked=new boolean[n];
        long[] answer=new long[queries.length];
        int pointer=0;
        for(int query=0;query<queries.length;query++){
            int index=queries[query][0];
            if(!marked[index]){
                marked[index]=true;
                remaining-=nums[index];
            }
            int need=queries[query][1];
            while(need>0){
                while(pointer<n&&marked[order[pointer]])pointer++;
                if(pointer==n)break;
                int chosen=order[pointer++];
                marked[chosen]=true;
                remaining-=nums[chosen];
                need--;
            }
            answer[query]=remaining;
        }
        return answer;
    }
}
