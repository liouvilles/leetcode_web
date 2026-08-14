const u=371,n="sum-of-two-integers",t="Sum of Two Integers",b="中等",d="数学",s=["数学","位运算"],y=!1,a="https://leetcode.cn/problems/sum-of-two-integers/",i="两整数之和",o=["位运算","异或","进位"],c="不使用加法和减法运算符，计算两个整数的和。",r="异或得到不含进位的和，与运算后左移一位得到进位；重复直到进位为零。",e=["负数按固定宽度补码同样适用","进位必须左移一位","循环结束时 a 保存完整结果"],l=[{id:"xor-carry",title:"异或和进位迭代",kind:"最优",idea:"把加法拆成无进位求和与进位传播两部分。",steps:["sum=a xor b","carry=(a&b)<<1","令 a=sum、b=carry 直到 b 为零"],complexity:{time:"O(32)",space:"O(1)"},code:{java:`class Solution {
    public int getSum(int a, int b) {
        while (b != 0) { int carry = (a & b) << 1; a ^= b; b = carry; } return a;
    }
}
`,kotlin:`class Solution {
    fun getSum(first: Int, second: Int): Int { var a = first; var b = second; while (b != 0) { val carry = (a and b) shl 1; a = a xor b; b = carry }; return a }
}
`,cpp:`class Solution {
public:
    int getSum(int a, int b) { while (b != 0) { unsigned int carry = ((unsigned int)a & (unsigned int)b) << 1; a ^= b; b = carry; } return a; }
};
`}}],f={id:371,slug:n,titleEn:t,difficulty:"中等",category:"数学",officialTags:s,paidOnly:!1,sourceUrl:a,title:i,studyTags:o,summary:c,insight:r,pitfalls:e,solutions:l};export{d as category,f as default,b as difficulty,u as id,r as insight,s as officialTags,y as paidOnly,e as pitfalls,n as slug,l as solutions,a as sourceUrl,o as studyTags,c as summary,i as title,t as titleEn};
