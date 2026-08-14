const r=191,n="number-of-1-bits",t="Number of 1 Bits",v="简单",d="位运算",e=["分治","位运算"],m=!1,s="https://leetcode.cn/problems/number-of-1-bits/",i="位 1 的个数",a=["位运算","Brian Kernighan","清除最低位一"],l="返回 32 位整数二进制表示中值为一的位数。",o="表达式 value & (value-1) 会清除最低的一个一位，因此循环次数正好等于一位数量。",u=["输入按 32 位模式处理","不能依赖算术右移处理负数","零的答案为零"],c=[{id:"clear-lowest-one",title:"逐次清除最低位一",kind:"最优",idea:"每轮删除一个已设置位并增加计数。",steps:["answer 初始化为零","value 非零时执行 value&=value-1","每轮计数加一"],complexity:{time:"O(number of 1 bits)",space:"O(1)"},code:{java:`class Solution {
    public int hammingWeight(int n) {
        int answer = 0;
        while (n != 0) { n &= n - 1; answer++; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun hammingWeight(input: Int): Int {
        var value = input; var answer = 0
        while (value != 0) { value = value and (value - 1); answer++ }
        return answer
    }
}
`,cpp:`class Solution {
public:
    int hammingWeight(int n) {
        unsigned int value = n; int answer = 0;
        while (value) { value &= value - 1; ++answer; }
        return answer;
    }
};
`}}],p={id:191,slug:n,titleEn:t,difficulty:"简单",category:"位运算",officialTags:e,paidOnly:!1,sourceUrl:s,title:i,studyTags:a,summary:l,insight:o,pitfalls:u,solutions:c};export{d as category,p as default,v as difficulty,r as id,o as insight,e as officialTags,m as paidOnly,u as pitfalls,n as slug,c as solutions,s as sourceUrl,a as studyTags,l as summary,i as title,t as titleEn};
