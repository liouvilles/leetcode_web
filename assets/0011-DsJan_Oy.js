const c=11,t="container-with-most-water",e="Container With Most Water",f="中等",i="数组与矩阵",n=["数组","双指针","贪心"],u=!1,h="https://leetcode.cn/problems/container-with-most-water/",s="盛最多水的容器",l=["双指针","短板效应","排除不可能区间"],r="数组中的每个高度代表一条竖线，选择两条竖线与横轴组成容器，求能够容纳的最大水量。",g="面积由较短边决定；向内移动较长边只会缩小宽度，因此只有移动短边才可能改善答案。",o=["面积使用两端距离而不是元素个数","每轮应移动较短的一侧","相等高度时移动任意一侧都不会漏解"],a=[{id:"two-pointers",title:"相向双指针",kind:"最优",idea:"从最宽区间开始，根据短板高度排除不可能产生更优解的一端。",steps:["左右指针放在数组两端","用宽度乘两端较小高度更新答案","移动高度较小的指针"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, best = 0;
        while (left < right) {
            best = Math.max(best, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) left++; else right--;
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var best = 0
        while (left < right) {
            best = maxOf(best, (right - left) * minOf(height[left], height[right]))
            if (height[left] <= height[right]) left++ else right--
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = (int)height.size() - 1, best = 0;
        while (left < right) {
            best = max(best, (right - left) * min(height[left], height[right]));
            if (height[left] <= height[right]) ++left; else --right;
        }
        return best;
    }
};
`}}],m={id:11,slug:t,titleEn:e,difficulty:"中等",category:i,officialTags:n,paidOnly:!1,sourceUrl:h,title:s,studyTags:l,summary:r,insight:g,pitfalls:o,solutions:a};export{i as category,m as default,f as difficulty,c as id,g as insight,n as officialTags,u as paidOnly,o as pitfalls,t as slug,a as solutions,h as sourceUrl,l as studyTags,r as summary,s as title,e as titleEn};
