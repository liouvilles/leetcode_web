const l=55,n="jump-game",t="Jump Game",d="中等",e="动态规划",s=["数组","动态规划","贪心"],m=!1,i="https://leetcode.cn/problems/jump-game/",r="跳跃游戏",a=["贪心","最远覆盖","不可达检测"],u="数组元素表示从当前位置最多可以向前跳跃的距离，判断能否从第一个位置到达最后一个位置。",o="只需维护已经能够到达的最远下标；当前下标一旦超过该边界，后续位置都不可能被访问。",f=["数组值表示最大跳跃距离而不是必须跳的距离","遍历范围不能超过当前可达边界","长度为一的数组已经位于终点"],c=[{id:"greedy-farthest",title:"最远覆盖贪心",kind:"最优",idea:"遍历所有可达位置，并持续扩大可以覆盖到的最远下标。",steps:["初始化最远位置为 0","若当前下标超过最远位置则立即失败","用当前位置加跳跃长度更新最远位置"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index > farthest) return false;
            farthest = Math.max(farthest, index + nums[index]);
            if (farthest >= nums.length - 1) return true;
        }
        return true;
    }
}
`,kotlin:`class Solution {
    fun canJump(nums: IntArray): Boolean {
        var farthest = 0
        for (index in nums.indices) {
            if (index > farthest) return false
            farthest = maxOf(farthest, index + nums[index])
            if (farthest >= nums.lastIndex) return true
        }
        return true
    }
}
`,cpp:`class Solution {
public:
    bool canJump(vector<int>& nums) {
        int farthest = 0;
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (index > farthest) return false;
            farthest = max(farthest, index + nums[index]);
            if (farthest >= (int)nums.size() - 1) return true;
        }
        return true;
    }
};
`}}],x={id:55,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:i,title:r,studyTags:a,summary:u,insight:o,pitfalls:f,solutions:c};export{e as category,x as default,d as difficulty,l as id,o as insight,s as officialTags,m as paidOnly,f as pitfalls,n as slug,c as solutions,i as sourceUrl,a as studyTags,u as summary,r as title,t as titleEn};
