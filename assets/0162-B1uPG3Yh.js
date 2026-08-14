const r=162,e="find-peak-element",t="Find Peak Element",a="中等",n="数组与矩阵",i=["数组","二分查找"],u=!1,l="https://leetcode.cn/problems/find-peak-element/",d="寻找峰值",s=["二分查找","局部趋势","峰值"],m="在相邻元素互不相等的数组中返回任意一个严格大于左右相邻值的峰值下标，边界外视为负无穷。",f="若中点小于右邻，沿上坡向右一定能到达峰值；否则中点本身或左侧存在峰值。",o=["答案可以是任意峰值","比较 middle 与 middle+1 可避免访问左边界外","右边界更新为 middle 以保留可能峰值"],c=[{id:"slope-binary-search",title:"沿上坡方向二分",kind:"最优",idea:"根据中点右侧斜率选择必含峰值的一半区间。",steps:["维护 [left,right] 峰值区间","上坡则 left=middle+1","下坡则 right=middle，最终两者相等"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1; else right = middle; }
        return left;
    }
}
`,kotlin:`class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0; var right = nums.lastIndex
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1 else right = middle }
        return left
    }
}
`,cpp:`class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1; else right = middle; }
        return left;
    }
};
`}}],g={id:162,slug:e,titleEn:t,difficulty:"中等",category:n,officialTags:i,paidOnly:!1,sourceUrl:l,title:d,studyTags:s,summary:m,insight:f,pitfalls:o,solutions:c};export{n as category,g as default,a as difficulty,r as id,f as insight,i as officialTags,u as paidOnly,o as pitfalls,e as slug,c as solutions,l as sourceUrl,s as studyTags,m as summary,d as title,t as titleEn};
