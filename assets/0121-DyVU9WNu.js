const b=121,n="best-time-to-buy-and-sell-stock",i="Best Time to Buy and Sell Stock",u="简单",e="动态规划",t=["数组","动态规划"],m=!1,s="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/",c="买卖股票的最佳时机",r=["前缀最值","单次交易","贪心"],l="只能先买入再卖出一次，根据每日价格求可获得的最大利润，也可以选择不交易。",o="把每一天当作卖出日，最优买入价就是它之前出现过的最低价格。",p=["买入必须早于卖出","价格持续下降时答案为 0","不要把单次交易写成可重复交易"],a=[{id:"enumerate-pairs",title:"枚举买卖日",kind:"基础",idea:"枚举所有合法的买入日和更晚的卖出日，记录最大价差。",steps:["枚举买入位置","枚举其后的卖出位置","用价差更新最大利润"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        for (int buy = 0; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                best = Math.max(best, prices[sell] - prices[buy]);
            }
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun maxProfit(prices: IntArray): Int {
        var best = 0
        for (buy in prices.indices) {
            for (sell in buy + 1 until prices.size) {
                best = maxOf(best, prices[sell] - prices[buy])
            }
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int best = 0;
        for (int buy = 0; buy < (int)prices.size(); ++buy)
            for (int sell = buy + 1; sell < (int)prices.size(); ++sell)
                best = max(best, prices[sell] - prices[buy]);
        return best;
    }
};
`}},{id:"prefix-min",title:"维护前缀最低价",kind:"最优",idea:"一次扫描，同时维护到目前为止的最低价格和最大利润。",steps:["用首日价格初始化最低价","计算今天卖出的利润","更新答案与最低价"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = Math.max(best, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var best = 0
        for (price in prices) {
            best = maxOf(best, price - minPrice)
            minPrice = minOf(minPrice, price)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = max(best, price - minPrice);
            minPrice = min(minPrice, price);
        }
        return best;
    }
};
`}}],f={id:121,slug:n,titleEn:i,difficulty:"简单",category:e,officialTags:t,paidOnly:!1,sourceUrl:s,title:c,studyTags:r,summary:l,insight:o,pitfalls:p,solutions:a};export{e as category,f as default,u as difficulty,b as id,o as insight,t as officialTags,m as paidOnly,p as pitfalls,n as slug,a as solutions,s as sourceUrl,r as studyTags,l as summary,c as title,i as titleEn};
