const u=169,n="majority-element",t="Majority Element",m="简单",e="数组与矩阵",o=["数组","哈希表","分治","排序","计数","Boyer–Moore Majority Vote Algorithm"],v=!1,i="https://leetcode.cn/problems/majority-element/",a="多数元素",s=["Boyer-Moore","投票抵消","常数空间"],c="找出数组中出现次数严格超过一半的元素，题目保证这样的元素一定存在。",l="把多数元素与其他元素两两抵消，多数元素最终仍会留下，因此只需维护一个候选值和票数。",d=["票数归零后当前元素应成为新候选","抵消过程依赖多数元素必然存在的前提","候选值变化不代表之前的统计需要回溯"],r=[{id:"boyer-moore-voting",title:"Boyer-Moore 投票",kind:"最优",idea:"相同元素给候选加票，不同元素减票，票数清零时更换候选。",steps:["票数为零时把当前值设为候选","当前值等于候选则加一，否则减一","遍历结束后候选即为多数元素"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, votes = 0;
        for (int value : nums) {
            if (votes == 0) candidate = value;
            votes += value == candidate ? 1 : -1;
        }
        return candidate;
    }
}
`,kotlin:`class Solution {
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var votes = 0
        for (value in nums) {
            if (votes == 0) candidate = value
            votes += if (value == candidate) 1 else -1
        }
        return candidate
    }
}
`,cpp:`class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0, votes = 0;
        for (int value : nums) {
            if (votes == 0) candidate = value;
            votes += value == candidate ? 1 : -1;
        }
        return candidate;
    }
};
`}}],y={id:169,slug:n,titleEn:t,difficulty:"简单",category:e,officialTags:o,paidOnly:!1,sourceUrl:i,title:a,studyTags:s,summary:c,insight:l,pitfalls:d,solutions:r};export{e as category,y as default,m as difficulty,u as id,l as insight,o as officialTags,v as paidOnly,d as pitfalls,n as slug,r as solutions,i as sourceUrl,s as studyTags,c as summary,a as title,t as titleEn};
