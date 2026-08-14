const m=45,n="jump-game-ii",t="Jump Game II",l="中等",e="动态规划",s=["数组","动态规划","贪心"],f=!1,i="https://leetcode.cn/problems/jump-game-ii/",r="跳跃游戏 II",u=["贪心分层","最远覆盖","最少步数"],a="数组元素表示从当前位置最多可跳的距离，计算从第一个位置到最后一个位置所需的最少跳跃次数。",c="当前一次跳跃能够覆盖的区间相当于 BFS 的一层；扫描到层末端时，再把边界扩展到本层可达的最远点。",d=["无需真正选择每一步落点","最后一个位置不需要继续扩展","题目保证终点可达"],o=[{id:"greedy-levels",title:"区间分层贪心",kind:"最优",idea:"扫描当前跳跃次数覆盖的所有位置，并收集下一次跳跃可到的最远边界。",steps:["维护 currentEnd 和 farthest","扫描到 currentEnd 时完成一次跳跃","把 currentEnd 更新为 farthest"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            farthest = Math.max(farthest, index + nums[index]);
            if (index == currentEnd) { jumps++; currentEnd = farthest; }
        }
        return jumps;
    }
}
`,kotlin:`class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        for (index in 0 until nums.lastIndex) { farthest = maxOf(farthest, index + nums[index]); if (index == currentEnd) { jumps++; currentEnd = farthest } }
        return jumps
    }
}
`,cpp:`class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index + 1 < (int)nums.size(); ++index) { farthest = max(farthest, index + nums[index]); if (index == currentEnd) { ++jumps; currentEnd = farthest; } }
        return jumps;
    }
};
`}}],p={id:45,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:i,title:r,studyTags:u,summary:a,insight:c,pitfalls:d,solutions:o};export{e as category,p as default,l as difficulty,m as id,c as insight,s as officialTags,f as paidOnly,d as pitfalls,n as slug,o as solutions,i as sourceUrl,u as studyTags,a as summary,r as title,t as titleEn};
