class Solution {
    public long pickGifts(int[] gifts,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int gift:gifts)heap.offer(gift);
        while(k-->0)heap.offer((int)Math.sqrt(heap.poll()));
        long answer=0;
        for(int gift:heap)answer+=gift;
        return answer;
    }
}
