class Solution {
    public long maxKelements(int[] nums,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int value:nums)heap.offer(value);
        long score=0;
        while(k-->0){
            int value=heap.poll();
            score+=value;
            heap.offer((value+2)/3);
        }
        return score;
    }
}
