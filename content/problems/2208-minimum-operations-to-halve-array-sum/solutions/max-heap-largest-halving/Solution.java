class Solution {
    public int halveArray(int[] nums){
        PriorityQueue<Double> heap=new PriorityQueue<>(Comparator.reverseOrder());
        double total=0,reduced=0;
        for(int value:nums){
            heap.offer((double)value);
            total+=value;
        }
        int operations=0;
        while(reduced<total/2){
            double half=heap.poll()/2;
            reduced+=half;
            heap.offer(half);
            operations++;
        }
        return operations;
    }
}
