class Solution {
    public boolean isPossible(int[] target){
        PriorityQueue<Long> heap=new PriorityQueue<>(Collections.reverseOrder());
        long total=0;
        for(int value:target){
            heap.offer((long)value);
            total+=value;
        }while(true){
            long maximum=heap.poll(),rest=total-maximum;
            if(maximum==1||rest==1)return true;
            if(rest==0||rest>=maximum||maximum%rest==0)return false;
            long previous=maximum%rest;
            total=rest+previous;
            heap.offer(previous);
        }
    }
}
