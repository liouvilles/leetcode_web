class Solution {
    public int minStoneSum(int[] piles,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int pile:piles)heap.offer(pile);
        while(k-->0){
            int value=heap.poll();
            heap.offer(value-value/2);
        }
        int answer=0;
        for(int value:heap)answer+=value;
        return answer;
    }
}
