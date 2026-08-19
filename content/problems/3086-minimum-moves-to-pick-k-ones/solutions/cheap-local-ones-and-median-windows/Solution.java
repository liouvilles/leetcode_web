class Solution {
    public long minimumMoves(int[] nums,int k,int maxChanges){
        List<Integer> ones=new ArrayList<>();
        int run=0,longest=0;
        for(int index=0;index<nums.length;index++){
            if(nums[index]==1){
                ones.add(index);
                run++;
                longest=Math.max(longest,run);
            }else run=0;
        }
        int cheap=Math.min(k,Math.min(3,longest));
        if(cheap+maxChanges>=k)return Math.max(0,cheap-1)+2L*(k-cheap);
        int required=k-maxChanges;
        long[] prefix=new long[ones.size()+1];
        for(int index=0;index<ones.size();index++)prefix[index+1]=prefix[index]+ones.get(index);
        long best=Long.MAX_VALUE;
        for(int left=0;left+required<=ones.size();left++){
            int right=left+required-1,middle=left+required/2;
            long median=ones.get(middle);
            long leftCost=median*(middle-left)-(prefix[middle]-prefix[left]);
            long rightCost=prefix[right+1]-prefix[middle+1]-median*(right-middle);
            best=Math.min(best,leftCost+rightCost);
        }
        return best+2L*maxChanges;
    }
}
