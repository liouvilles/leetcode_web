const r=338,t="counting-bits",n="Counting Bits",v="简单",i="动态规划",s=["动态规划","位运算"],d=!1,l="https://leetcode.cn/problems/counting-bits/",o="比特位计数",e=["动态规划","最低位","位运算"],u="对从 0 到 n 的每个整数，返回其二进制表示中一位的数量。",a="i 右移一位会去掉最低位，因此 bits[i]=bits[i>>1]+(i&1)。",c=["答案包含零对应的位置","数组长度为 n+1","最低位贡献只有零或一"],b=[{id:"lowest-bit-dp",title:"右移递推",kind:"最优",idea:"复用更小整数的计数并加上当前最低位。",steps:["bits[0] 默认为零","从一遍历到 n","按 bits[i>>1]+(i&1) 计算"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1]; for (int value = 1; value <= n; value++) bits[value] = bits[value >> 1] + (value & 1); return bits;
    }
}
`,kotlin:`class Solution {
    fun countBits(n: Int): IntArray { val bits = IntArray(n + 1); for (value in 1..n) bits[value] = bits[value shr 1] + (value and 1); return bits }
}
`,cpp:`class Solution {
public:
    vector<int> countBits(int n) { vector<int> bits(n + 1); for (int value = 1; value <= n; ++value) bits[value] = bits[value >> 1] + (value & 1); return bits; }
};
`}}],p={id:338,slug:t,titleEn:n,difficulty:"简单",category:i,officialTags:s,paidOnly:!1,sourceUrl:l,title:o,studyTags:e,summary:u,insight:a,pitfalls:c,solutions:b};export{i as category,p as default,v as difficulty,r as id,a as insight,s as officialTags,d as paidOnly,c as pitfalls,t as slug,b as solutions,l as sourceUrl,e as studyTags,u as summary,o as title,n as titleEn};
