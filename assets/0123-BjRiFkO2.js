const y=123,l="best-time-to-buy-and-sell-stock-iii",e="Best Time to Buy and Sell Stock III",p="困难",s="动态规划",t=["数组","动态规划"],b=!1,i="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/",n="买卖股票的最佳时机 III",c=["动态规划","状态机","股票"],r="在最多完成两笔买卖且任意时刻最多持有一股的条件下，计算可获得的最大利润。",u="依次维护第一次买入、第一次卖出、第二次买入、第二次卖出的最佳余额，每个价格更新四个状态。",a=["买入状态保存的是扣款后的最大余额","第二次买入依赖第一次卖出的利润","不足两笔交易也包含在状态中"],o=[{id:"four-state-dp",title:"四状态滚动更新",kind:"最优",idea:"把两笔交易拆成四个有顺序的动作，用常量空间保存各动作后的最优值。",steps:["buy1=max(buy1,-price)","sell1 与 buy2 依次更新","sell2 更新为最终答案"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxProfit(int[] prices) { int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0; for (int price : prices) { buy1 = Math.max(buy1, -price); sell1 = Math.max(sell1, buy1 + price); buy2 = Math.max(buy2, sell1 - price); sell2 = Math.max(sell2, buy2 + price); } return sell2; }
}
`,kotlin:`class Solution {
    fun maxProfit(prices: IntArray): Int { var buy1 = Int.MIN_VALUE; var sell1 = 0; var buy2 = Int.MIN_VALUE; var sell2 = 0; for (price in prices) { buy1 = maxOf(buy1, -price); sell1 = maxOf(sell1, buy1 + price); buy2 = maxOf(buy2, sell1 - price); sell2 = maxOf(sell2, buy2 + price) }; return sell2 }
}
`,cpp:`class Solution {
public:
    int maxProfit(vector<int>& prices) { int buy1 = INT_MIN, sell1 = 0, buy2 = INT_MIN, sell2 = 0; for (int price : prices) { buy1 = max(buy1, -price); sell1 = max(sell1, buy1 + price); buy2 = max(buy2, sell1 - price); sell2 = max(sell2, buy2 + price); } return sell2; }
};
`}}],m={id:123,slug:l,titleEn:e,difficulty:"困难",category:s,officialTags:t,paidOnly:!1,sourceUrl:i,title:n,studyTags:c,summary:r,insight:u,pitfalls:a,solutions:o};export{s as category,m as default,p as difficulty,y as id,u as insight,t as officialTags,b as paidOnly,a as pitfalls,l as slug,o as solutions,i as sourceUrl,c as studyTags,r as summary,n as title,e as titleEn};
