const p=309,o="best-time-to-buy-and-sell-stock-with-cooldown",l="Best Time to Buy and Sell Stock with Cooldown",y="中等",t="动态规划",d=["数组","动态规划"],m=!1,s="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/",n="买卖股票的最佳时机含冷冻期",e=["状态机 DP","冷冻期","股票交易"],i="可以多次买卖一只股票，但卖出后的下一天不能买入；任意时刻最多持有一股，求最大利润。",a="每天只需维护持有、当天卖出、空仓休息三种状态；买入只能从前一天休息状态转移。",c=["卖出后隔一天才能再次买入","同一天不能同时完成多次交易","最终答案不能取仍持有股票的状态"],r=[{id:"state-machine-dp",title:"三状态滚动 DP",kind:"最优",idea:"按持有、卖出、休息三种状态滚动更新，状态定义直接编码冷冻约束。",steps:["hold=max(oldHold,oldRest-price)","sold=oldHold+price","rest=max(oldRest,oldSold)，最终取 sold 与 rest 较大值"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < prices.length; day++) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = Math.max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = Math.max(oldRest, oldSold);
        }
        return Math.max(sold, rest);
    }
}
`,kotlin:`class Solution {
    fun maxProfit(prices: IntArray): Int {
        var hold = -prices[0]
        var sold = 0
        var rest = 0
        for (day in 1 until prices.size) {
            val oldHold = hold
            val oldSold = sold
            val oldRest = rest
            hold = maxOf(oldHold, oldRest - prices[day])
            sold = oldHold + prices[day]
            rest = maxOf(oldRest, oldSold)
        }
        return maxOf(sold, rest)
    }
}
`,cpp:`class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < (int)prices.size(); ++day) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = max(oldRest, oldSold);
        }
        return max(sold, rest);
    }
};
`}}],u={id:309,slug:o,titleEn:l,difficulty:"中等",category:t,officialTags:d,paidOnly:!1,sourceUrl:s,title:n,studyTags:e,summary:i,insight:a,pitfalls:c,solutions:r};export{t as category,u as default,y as difficulty,p as id,a as insight,d as officialTags,m as paidOnly,c as pitfalls,o as slug,r as solutions,s as sourceUrl,e as studyTags,i as summary,n as title,l as titleEn};
