const c=167,t="two-sum-ii-input-array-is-sorted",n="Two Sum II - Input Array Is Sorted",g="中等",e="数组与矩阵",i=["数组","双指针","二分查找"],m=!1,r="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/",s="两数之和 II：输入有序数组",l=["双指针","有序数组","一基下标"],u="在非递减数组中找出两个不同元素之和等于目标值，并返回从一开始计数的两个下标。",o="两端之和偏小只能增大左端，偏大只能减小右端，有序性保证不会漏掉唯一答案。",a=["返回下标从一开始","不能重复使用同一个元素","题目保证恰有一个答案"],f=[{id:"two-pointers",title:"相向双指针",kind:"最优",idea:"根据当前两端和与目标的大小单调收缩搜索区间。",steps:["left=0、right=n-1","和偏小左移，偏大右移","命中后返回 left+1 与 right+1"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) { int sum = numbers[left] + numbers[right]; if (sum == target) return new int[] {left + 1, right + 1}; if (sum < target) left++; else right--; }
        return new int[0];
    }
}
`,kotlin:`class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0; var right = numbers.lastIndex
        while (left < right) { val sum = numbers[left] + numbers[right]; if (sum == target) return intArrayOf(left + 1, right + 1); if (sum < target) left++ else right-- }
        return intArrayOf()
    }
}
`,cpp:`class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0, right = numbers.size() - 1;
        while (left < right) { int sum = numbers[left] + numbers[right]; if (sum == target) return {left + 1, right + 1}; if (sum < target) ++left; else --right; }
        return {};
    }
};
`}}],h={id:167,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:i,paidOnly:!1,sourceUrl:r,title:s,studyTags:l,summary:u,insight:o,pitfalls:a,solutions:f};export{e as category,h as default,g as difficulty,c as id,o as insight,i as officialTags,m as paidOnly,a as pitfalls,t as slug,f as solutions,r as sourceUrl,l as studyTags,u as summary,s as title,n as titleEn};
