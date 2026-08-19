class Solution {
    public int getMaximumConsecutive(int[] coins){
        Arrays.sort(coins);
        int reachable=0;
        for(int coin:coins){
            if(coin>reachable+1)break;
            reachable+=coin;
        }
        return reachable+1;
    }
}
