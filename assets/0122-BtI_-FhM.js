const d=122,t="best-time-to-buy-and-sell-stock-ii",i="Best Time to Buy and Sell Stock II",f="中等",s="动态规划",n=["数组","动态规划","贪心"],y=!1,o="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/",e="买卖股票的最佳时机 II",c=["贪心","股票","正差分"],r="每天最多持有一股且可以买卖多次，计算价格序列中能获得的最大总利润。",a="任意上涨区间的首尾利润等于其中所有相邻正差之和，因此累加每次上涨即可实现最优。",p=["同一天可以卖出后再买入","下降差值不能计入利润","无需显式寻找完整波谷和波峰"],l=[{id:"sum-positive-differences",title:"累加相邻正收益",kind:"最优",idea:"把每段上涨拆成若干天的一步交易，利润总和不变。",steps:["从第二天开始扫描","若 price[i]>price[i-1] 则累加差值","返回累计利润"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxProfit(int[] prices) { int profit = 0; for (int day = 1; day < prices.length; day++) profit += Math.max(0, prices[day] - prices[day - 1]); return profit; }
}
`,kotlin:`class Solution {
    fun maxProfit(prices: IntArray): Int { var profit = 0; for (day in 1 until prices.size) profit += maxOf(0, prices[day] - prices[day - 1]); return profit }
}
`,cpp:`class Solution {
public:
    int maxProfit(vector<int>& prices) { int profit = 0; for (int day = 1; day < (int)prices.size(); ++day) profit += max(0, prices[day] - prices[day - 1]); return profit; }
};
`}}],u={id:122,slug:t,titleEn:i,difficulty:"中等",category:s,officialTags:n,paidOnly:!1,sourceUrl:o,title:e,studyTags:c,summary:r,insight:a,pitfalls:p,solutions:l};export{s as category,u as default,f as difficulty,d as id,a as insight,n as officialTags,y as paidOnly,p as pitfalls,t as slug,l as solutions,o as sourceUrl,c as studyTags,r as summary,e as title,i as titleEn};
