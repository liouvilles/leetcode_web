const f=300,t="longest-increasing-subsequence",n="Longest Increasing Subsequence",d="中等",e="动态规划",i=["数组","二分查找","动态规划","最长递增子序列"],g=!1,l="https://leetcode.cn/problems/longest-increasing-subsequence/",s="最长递增子序列",a=["贪心","二分查找","最小结尾"],o="求整数数组中严格递增子序列的最大长度，子序列元素不要求连续。",u="对每个长度维护可能的最小结尾值；结尾越小越容易接入后续元素，新值用二分替换第一个不小于它的位置。",c=["子序列不要求连续","严格递增要求使用 lower bound","tails 保存的是最优结尾而不一定是原序列中的最终答案序列"],r=[{id:"patience-binary-search",title:"最小结尾二分",kind:"最优",idea:"用 tails[length-1] 表示长度为 length 的递增子序列最小末值。",steps:["在有效 tails 中找首个 >= value 的位置","存在则用 value 替换","不存在则把有效长度加一"],complexity:{time:"O(n log n)",space:"O(n)"},code:{java:`class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; int size = 0;
        for (int value : nums) { int left = 0, right = size; while (left < right) { int middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1; else right = middle; } tails[left] = value; if (left == size) size++; }
        return size;
    }
}
`,kotlin:`class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = IntArray(nums.size); var size = 0
        for (value in nums) { var left = 0; var right = size; while (left < right) { val middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1 else right = middle }; tails[left] = value; if (left == size) size++ }
        return size
    }
}
`,cpp:`class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> tails;
        for (int value : nums) { auto position = lower_bound(tails.begin(), tails.end(), value); if (position == tails.end()) tails.push_back(value); else *position = value; }
        return tails.size();
    }
};
`}}],m={id:300,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:i,paidOnly:!1,sourceUrl:l,title:s,studyTags:a,summary:o,insight:u,pitfalls:c,solutions:r};export{e as category,m as default,d as difficulty,f as id,u as insight,i as officialTags,g as paidOnly,c as pitfalls,t as slug,r as solutions,l as sourceUrl,a as studyTags,o as summary,s as title,n as titleEn};
