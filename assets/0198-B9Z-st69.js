const p=198,n="house-robber",o="House Robber",a="中等",e="动态规划",r=["数组","动态规划"],f=!1,s="https://leetcode.cn/problems/house-robber/",i="打家劫舍",t=["动态规划","相邻互斥","滚动状态"],u="从一排房屋中选择若干间获取金额，但不能选择相邻房屋，求能够获得的最大总金额。",c="处理当前房屋时只有两种最优选择：跳过它继承上一状态，或选择它并加上隔一间之前的最优值。",v=["选择当前房屋时不能使用上一间的状态","金额可以为零","两个滚动变量更新时要保留旧值含义"],l=[{id:"rolling-dp",title:"滚动动态规划",kind:"最优",idea:"用 previous 表示到前一间的最优值，beforePrevious 表示到前两间的最优值。",steps:["初始化两个历史状态为零","当前最优取跳过与选择当前房屋的较大值","滚动更新历史状态"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int rob(int[] nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = Math.max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
`,kotlin:`class Solution {
    fun rob(nums: IntArray): Int {
        var beforePrevious = 0
        var previous = 0
        for (money in nums) {
            val current = maxOf(previous, beforePrevious + money)
            beforePrevious = previous
            previous = current
        }
        return previous
    }
}
`,cpp:`class Solution {
public:
    int rob(vector<int>& nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
};
`}}],b={id:198,slug:n,titleEn:o,difficulty:"中等",category:e,officialTags:r,paidOnly:!1,sourceUrl:s,title:i,studyTags:t,summary:u,insight:c,pitfalls:v,solutions:l};export{e as category,b as default,a as difficulty,p as id,c as insight,r as officialTags,f as paidOnly,v as pitfalls,n as slug,l as solutions,s as sourceUrl,t as studyTags,u as summary,i as title,o as titleEn};
