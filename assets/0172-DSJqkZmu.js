const u=172,n="factorial-trailing-zeroes",t="Factorial Trailing Zeroes",f="中等",p="数学",s=["数学"],w=!1,i="https://leetcode.cn/problems/factorial-trailing-zeroes/",e="阶乘后的零",o=["数学","因子计数","整除"],a="计算 n 的阶乘十进制表示末尾连续零的数量。",r="每个末尾零需要一对因子 2 和 5，而阶乘中 2 更多，因此只需累计 5、25、125 等贡献的五因子数量。",l=["25 的倍数会额外贡献一个五因子","无需真正计算阶乘","循环不断令 n 除以五即可覆盖所有幂次"],c=[{id:"count-factors-of-five",title:"累计五因子",kind:"最优",idea:"反复整除五，每轮商表示至少还能贡献一个五因子的数的数量。",steps:["answer 初始化为零","n/=5","把当前 n 加入 answer，直到 n 为零"],complexity:{time:"O(log5 n)",space:"O(1)"},code:{java:`class Solution {
    public int trailingZeroes(int n) { int answer = 0; while (n > 0) { n /= 5; answer += n; } return answer; }
}
`,kotlin:`class Solution {
    fun trailingZeroes(input: Int): Int { var n = input; var answer = 0; while (n > 0) { n /= 5; answer += n }; return answer }
}
`,cpp:`class Solution {
public:
    int trailingZeroes(int n) { int answer = 0; while (n > 0) { n /= 5; answer += n; } return answer; }
};
`}}],d={id:172,slug:n,titleEn:t,difficulty:"中等",category:"数学",officialTags:s,paidOnly:!1,sourceUrl:i,title:e,studyTags:o,summary:a,insight:r,pitfalls:l,solutions:c};export{p as category,d as default,f as difficulty,u as id,r as insight,s as officialTags,w as paidOnly,l as pitfalls,n as slug,c as solutions,i as sourceUrl,o as studyTags,a as summary,e as title,t as titleEn};
