class Solution {
    public int[] smallestRange(List<List<Integer>> nums){
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(item->item[0]));
        int maximum=Integer.MIN_VALUE;
        for(int row=0;row<nums.size();row++){
            int value=nums.get(row).get(0);
            heap.offer(new int[]{
                value,row,0
            });
            maximum=Math.max(maximum,value);
        }
        int bestLeft=heap.peek()[0],bestRight=maximum;
        while(true){
            int[] item=heap.poll();
            int minimum=item[0];
            if(maximum-minimum<bestRight-bestLeft||(maximum-minimum==bestRight-bestLeft&&minimum<bestLeft)){
                bestLeft=minimum;
                bestRight=maximum;
            }
            int nextIndex=item[2]+1;
            if(nextIndex==nums.get(item[1]).size())break;
            int next=nums.get(item[1]).get(nextIndex);
            heap.offer(new int[]{
                next,item[1],nextIndex
            });
            maximum=Math.max(maximum,next);
        }
        return new int[]{
            bestLeft,bestRight
        };
    }
}
