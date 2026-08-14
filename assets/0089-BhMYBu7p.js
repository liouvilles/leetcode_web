const d=89,n="gray-code",t="Gray Code",v="中等",e="搜索与回溯",a=["数学","回溯","位运算"],f=!1,s="https://leetcode.cn/problems/gray-code/",i="格雷编码",l=["位运算","数学构造","异或"],o="生成长度为 2^n 的 n 位格雷码序列，从零开始且相邻值恰好只有一个二进制位不同。",r="自然数 i 的二进制反射格雷码为 i XOR (i>>1)，按 i 递增即可得到满足环状相邻条件的序列。",c=["序列必须从零开始","结果共有 2^n 个数","使用异或而不是普通加法组合高低位"],u=[{id:"binary-reflected-formula",title:"反射格雷码公式",kind:"最优",idea:"直接对区间内每个整数应用 i^(i>>1) 映射。",steps:["计算 total=1<<n","枚举 i 从 0 到 total-1","追加 i XOR (i>>1)"],complexity:{time:"O(2^n)",space:"O(1) excluding output"},code:{java:`class Solution {
    public List<Integer> grayCode(int n) { List<Integer> answer = new ArrayList<>(); for (int value = 0; value < (1 << n); value++) answer.add(value ^ (value >> 1)); return answer; }
}
`,kotlin:`class Solution {
    fun grayCode(n: Int): List<Int> { val answer = mutableListOf<Int>(); for (value in 0 until (1 shl n)) answer.add(value xor (value shr 1)); return answer }
}
`,cpp:`class Solution {
public:
    vector<int> grayCode(int n) { vector<int> answer; for (int value = 0; value < (1 << n); ++value) answer.push_back(value ^ (value >> 1)); return answer; }
};
`}}],y={id:89,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:a,paidOnly:!1,sourceUrl:s,title:i,studyTags:l,summary:o,insight:r,pitfalls:c,solutions:u};export{e as category,y as default,v as difficulty,d as id,r as insight,a as officialTags,f as paidOnly,c as pitfalls,n as slug,u as solutions,s as sourceUrl,l as studyTags,o as summary,i as title,t as titleEn};
