class Solution {
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones)heap.offer(stone);
        while(heap.size()>1){
            int first=heap.poll(),second=heap.poll();
            if(first>second)heap.offer(first-second);
        }
        return heap.isEmpty()?0:heap.peek();
    }
}
