class Solution {
    public int[] deckRevealedIncreasing(int[] deck){
        Arrays.sort(deck);
        int[] answer=new int[deck.length];
        Deque<Integer> indices=new ArrayDeque<>();
        for(int i=0;i<deck.length;i++)indices.offer(i);
        for(int value:deck){
            answer[indices.poll()]=value;
            if(!indices.isEmpty())indices.offer(indices.poll());
        }
        return answer;
    }
}
