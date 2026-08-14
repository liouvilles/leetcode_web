const m=137,n="single-number-ii",s="Single Number II",d="中等",o="数组与矩阵",t=["数组","位运算"],v=!1,e="https://leetcode.cn/problems/single-number-ii/",i="只出现一次的数字 II",l=["位运算","有限状态机","异或"],u="数组中除一个数出现一次外，其余数都恰好出现三次，在线性时间和常量空间内找出单独的数。",a="对每个二进制位维护出现次数模三的两位状态 ones 和 twos，第三次出现时两者都会清零。",c=["负数同样按补码逐位处理","更新 twos 时使用更新后的 ones","不能使用额外哈希表才能满足空间要求"],r=[{id:"bit-state-machine",title:"位状态机模三计数",kind:"最优",idea:"并行处理所有二进制位，让状态在 00→01→10→00 间循环。",steps:["ones=(ones xor value) and not twos","twos=(twos xor value) and not ones","所有数处理后 ones 即只出现一次的数"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int singleNumber(int[] nums) { int ones = 0, twos = 0; for (int value : nums) { ones = (ones ^ value) & ~twos; twos = (twos ^ value) & ~ones; } return ones; }
}
`,kotlin:`class Solution {
    fun singleNumber(nums: IntArray): Int { var ones = 0; var twos = 0; for (value in nums) { ones = (ones xor value) and twos.inv(); twos = (twos xor value) and ones.inv() }; return ones }
}
`,cpp:`class Solution {
public:
    int singleNumber(vector<int>& nums) { int ones = 0, twos = 0; for (int value : nums) { ones = (ones ^ value) & ~twos; twos = (twos ^ value) & ~ones; } return ones; }
};
`}}],w={id:137,slug:n,titleEn:s,difficulty:"中等",category:o,officialTags:t,paidOnly:!1,sourceUrl:e,title:i,studyTags:l,summary:u,insight:a,pitfalls:c,solutions:r};export{o as category,w as default,d as difficulty,m as id,a as insight,t as officialTags,v as paidOnly,c as pitfalls,n as slug,r as solutions,e as sourceUrl,l as studyTags,u as summary,i as title,s as titleEn};
