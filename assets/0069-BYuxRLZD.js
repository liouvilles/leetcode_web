const c=69,t="sqrtx",n="Sqrt(x)",f="简单",m="数学",e=["数学","二分查找","Newton's Method"],g=!1,i="https://leetcode.cn/problems/sqrtx/",l="x 的平方根",s=["二分答案","整数溢出","向下取整"],d="计算非负整数 x 的算术平方根并向下取整，不使用内置幂函数。",r="答案满足平方不超过 x，可以在整数区间内二分查找最后一个满足条件的数。",o=["乘法需要使用长整型避免溢出","答案要求向下取整","零和一可以由通用逻辑处理"],a=[{id:"binary-answer",title:"二分最后可行值",kind:"最优",idea:"在 [0,x] 内查找平方不大于 x 的最大整数。",steps:["维护当前可行答案","middle² 不超过 x 时记录并向右找","否则向左收缩"],complexity:{time:"O(log x)",space:"O(1)"},code:{java:`class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, answer = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle <= x) { answer = middle; left = middle + 1; } else right = middle - 1;
        }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0; var right = x; var answer = 0
        while (left <= right) { val middle = left + (right - left) / 2; if (middle.toLong() * middle <= x) { answer = middle; left = middle + 1 } else right = middle - 1 }
        return answer
    }
}
`,cpp:`class Solution {
public:
    int mySqrt(int x) {
        int left = 0, right = x, answer = 0;
        while (left <= right) { int middle = left + (right - left) / 2; if ((long long)middle * middle <= x) { answer = middle; left = middle + 1; } else right = middle - 1; }
        return answer;
    }
};
`}}],x={id:69,slug:t,titleEn:n,difficulty:"简单",category:"数学",officialTags:e,paidOnly:!1,sourceUrl:i,title:l,studyTags:s,summary:d,insight:r,pitfalls:o,solutions:a};export{m as category,x as default,f as difficulty,c as id,r as insight,e as officialTags,g as paidOnly,o as pitfalls,t as slug,a as solutions,i as sourceUrl,s as studyTags,d as summary,l as title,n as titleEn};
