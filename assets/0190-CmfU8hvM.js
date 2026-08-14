const u=190,n="reverse-bits",t="Reverse Bits",p="简单",b="位运算",s=["分治","位运算"],d=!1,e="https://leetcode.cn/problems/reverse-bits/",i="颠倒二进制位",r=["位运算","固定 32 位","无符号右移"],a="把一个 32 位整数的所有二进制位顺序颠倒并返回结果。",o="重复 32 次：把答案左移一位并加入输入最低位，再对输入执行无符号右移。",l=["必须处理固定 32 位，包括前导零","Java 和 Kotlin 要使用无符号右移","循环次数不能根据数值最高位提前结束"],c=[{id:"bit-by-bit",title:"逐位反转",kind:"最优",idea:"每轮从输入低位取一位，按相反顺序追加到结果。",steps:["结果左移并或上 n&1","输入无符号右移一位","固定执行 32 轮"],complexity:{time:"O(32)",space:"O(1)"},code:{java:`class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int bit = 0; bit < 32; bit++) { answer = (answer << 1) | (n & 1); n >>>= 1; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun reverseBits(input: Int): Int {
        var value = input; var answer = 0
        repeat(32) { answer = (answer shl 1) or (value and 1); value = value ushr 1 }
        return answer
    }
}
`,cpp:`class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t answer = 0;
        for (int bit = 0; bit < 32; ++bit) { answer = (answer << 1) | (n & 1U); n >>= 1; }
        return answer;
    }
};
`}}],v={id:190,slug:n,titleEn:t,difficulty:"简单",category:"位运算",officialTags:s,paidOnly:!1,sourceUrl:e,title:i,studyTags:r,summary:a,insight:o,pitfalls:l,solutions:c};export{b as category,v as default,p as difficulty,u as id,o as insight,s as officialTags,d as paidOnly,l as pitfalls,n as slug,c as solutions,e as sourceUrl,r as studyTags,a as summary,i as title,t as titleEn};
