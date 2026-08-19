class Solution {
    public long kSum(int[] nums,int k){
        long maximum=0;
        long[] values=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)maximum+=nums[i];
            values[i]=Math.abs((long)nums[i]);
        }
        Arrays.sort(values);
        if(k==1)return maximum;
        PriorityQueue<long[]> heap=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        heap.add(new long[]{
            values[0],0
        });
        long loss=0;
        for(int rank=2;rank<=k;rank++){
            long[] state=heap.poll();
            loss=state[0];
            int index=(int)state[1];
            if(index+1<values.length){
                heap.add(new long[]{
                    loss+values[index+1],index+1
                });
                heap.add(new long[]{
                    loss-values[index]+values[index+1],index+1
                });
            }
        }
        return maximum-loss;
    }
}
