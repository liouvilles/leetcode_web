const m=136,n="single-number",s="Single Number",d="简单",t="数组与矩阵",e=["数组","位运算"],f=!1,i="https://leetcode.cn/problems/single-number/",l="只出现一次的数字",o=["异或","成对抵消","常数空间"],r="数组中除一个元素只出现一次外，其余元素都恰好出现两次，找出这个单独元素。",a="异或满足相同数抵消为零且顺序无关，把所有元素异或后只剩单独值。",u=["不能依赖排序或额外集合才能达到目标空间复杂度","负数按位异或同样成立","初始结果应为零"],c=[{id:"xor-cancellation",title:"全数组异或抵消",kind:"最优",idea:"利用 x xor x = 0 和 x xor 0 = x 消除所有成对元素。",steps:["结果初始化为零","依次与每个元素异或","返回最终剩余值"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int value : nums) answer ^= value;
        return answer;
    }
}
`,kotlin:`class Solution {
    fun singleNumber(nums: IntArray): Int {
        var answer = 0
        for (value in nums) answer = answer xor value
        return answer
    }
}
`,cpp:`class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int answer = 0;
        for (int value : nums) answer ^= value;
        return answer;
    }
};
`}}],p={id:136,slug:n,titleEn:s,difficulty:"简单",category:t,officialTags:e,paidOnly:!1,sourceUrl:i,title:l,studyTags:o,summary:r,insight:a,pitfalls:u,solutions:c};export{t as category,p as default,d as difficulty,m as id,a as insight,e as officialTags,f as paidOnly,u as pitfalls,n as slug,c as solutions,i as sourceUrl,o as studyTags,r as summary,l as title,s as titleEn};
