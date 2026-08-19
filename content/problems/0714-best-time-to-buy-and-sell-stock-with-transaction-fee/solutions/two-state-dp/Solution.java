class Solution {
    public int maxProfit(int[] prices,int fee){
        int cash=0,hold=-prices[0];
        for(int i=1;i<prices.length;i++){
            int oldCash=cash;
            cash=Math.max(cash,hold+prices[i]-fee);
            hold=Math.max(hold,oldCash-prices[i]);
        }
        return cash;
    }
}
