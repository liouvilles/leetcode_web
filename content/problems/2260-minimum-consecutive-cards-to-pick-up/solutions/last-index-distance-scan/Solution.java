class Solution {
    public int minimumCardPickup(int[] cards){
        Map<Integer,Integer> last=new HashMap<>();
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(last.containsKey(cards[i]))answer=Math.min(answer,i-last.get(cards[i])+1);
            last.put(cards[i],i);
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}
