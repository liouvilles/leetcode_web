const f=42,t="trapping-rain-water",i="Trapping Rain Water",M="困难",n="动态规划",e=["数组","双指针","动态规划","栈","单调栈"],o=!1,h="https://leetcode.cn/problems/trapping-rain-water/",s="接雨水",a=["前后缀最大值","短板原理","空间优化"],r="给定一组非负柱高，计算下雨后这些柱子之间能够留住的水量。",g="位置 i 的水位由左侧最高柱和右侧最高柱中的较矮者决定，再减去当前位置高度。",l=["边界位置无法蓄水","累加的是每个位置上方的水量","双指针移动哪侧取决于两侧当前高度"],x=[{id:"enumerate-columns",title:"逐列向两侧扫描",kind:"基础",idea:"对每个内部位置分别扫描左侧和右侧最高柱，再计算这一列能够容纳的水。",steps:["枚举每个非边界位置","向两侧扫描得到 leftMax 与 rightMax","累加 min(leftMax, rightMax) - height[i]"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public int trap(int[] height) {
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left <= i; left++) leftMax = Math.max(leftMax, height[left]);
            for (int right = i; right < height.length; right++) rightMax = Math.max(rightMax, height[right]);
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}
`,kotlin:`class Solution {
    fun trap(height: IntArray): Int {
        var water = 0
        for (i in 1 until height.lastIndex) {
            var leftMax = 0
            var rightMax = 0
            for (left in 0..i) leftMax = maxOf(leftMax, height[left])
            for (right in i..height.lastIndex) rightMax = maxOf(rightMax, height[right])
            water += minOf(leftMax, rightMax) - height[i]
        }
        return water
    }
}
`,cpp:`class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        for (int i = 1; i + 1 < (int)height.size(); ++i) {
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left <= i; ++left) leftMax = max(leftMax, height[left]);
            for (int right = i; right < (int)height.size(); ++right) rightMax = max(rightMax, height[right]);
            water += min(leftMax, rightMax) - height[i];
        }
        return water;
    }
};
`}},{id:"prefix-suffix-max",title:"前后缀最大值",kind:"进阶",idea:"预先计算每个位置左侧与右侧最高柱，把重复扫描变成常数时间查询。",steps:["从左到右构造 leftMax","从右到左构造 rightMax","逐位置计算并累加水量"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; i++) water += Math.min(leftMax[i], rightMax[i]) - height[i];
        return water;
    }
}
`,kotlin:`class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)
        leftMax[0] = height[0]
        for (i in 1 until height.size) leftMax[i] = maxOf(leftMax[i - 1], height[i])
        rightMax[height.lastIndex] = height.last()
        for (i in height.lastIndex - 1 downTo 0) rightMax[i] = maxOf(rightMax[i + 1], height[i])
        var water = 0
        for (i in height.indices) water += minOf(leftMax[i], rightMax[i]) - height[i]
        return water
    }
}
`,cpp:`class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> leftMax(n), rightMax(n);
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) leftMax[i] = max(leftMax[i - 1], height[i]);
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) rightMax[i] = max(rightMax[i + 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; ++i) water += min(leftMax[i], rightMax[i]) - height[i];
        return water;
    }
};
`}},{id:"two-pointers",title:"双指针空间优化",kind:"最优",idea:"较矮一侧的最高值已经足以确定该侧当前位置水量，因此可以边移动边结算。",steps:["左右指针从两端出发并维护两侧最高值","处理当前高度较矮的一侧","用该侧最高值减去当前高度并移动指针"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
}
`,kotlin:`class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var leftMax = 0
        var rightMax = 0
        var water = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = maxOf(leftMax, height[left])
                water += leftMax - height[left++]
            } else {
                rightMax = maxOf(rightMax, height[right])
                water += rightMax - height[right--]
            }
        }
        return water
    }
}
`,cpp:`class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = max(leftMax, height[left]);
                water += leftMax - height[left++];
            } else {
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
};
`}}],c={id:42,slug:t,titleEn:i,difficulty:"困难",category:n,officialTags:e,paidOnly:!1,sourceUrl:h,title:"接雨水",studyTags:a,summary:r,insight:g,pitfalls:l,solutions:x};export{n as category,c as default,M as difficulty,f as id,g as insight,e as officialTags,o as paidOnly,l as pitfalls,t as slug,x as solutions,h as sourceUrl,a as studyTags,r as summary,s as title,i as titleEn};
