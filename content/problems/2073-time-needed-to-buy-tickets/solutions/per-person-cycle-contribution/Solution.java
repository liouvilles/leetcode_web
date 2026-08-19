class Solution {
    public int timeRequiredToBuy(int[] tickets,int k){
        int answer=0;
        for(int i=0;i<tickets.length;i++)answer+=Math.min(tickets[i],tickets[k]-(i>k?1:0));
        return answer;
    }
}
