class Solution {
    public int maxProfit(int k,int[] prices){
        if(k>=prices.length/2){
            int p=0;
            for(int i=1;i<prices.length;i++)p+=Math.max(0,prices[i]-prices[i-1]);
            return p;
        }
        int[] buy=new int[k+1],sell=new int[k+1];
        Arrays.fill(buy,Integer.MIN_VALUE/2);
        for(int price:prices)for(int t=1;t<=k;t++){
            buy[t]=Math.max(buy[t],sell[t-1]-price);
            sell[t]=Math.max(sell[t],buy[t]+price);
        }
        return sell[k];
    }
}
