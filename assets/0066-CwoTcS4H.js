const a=66,i="plus-one",n="Plus One",g="简单",t="数组与矩阵",s=["数组","数学"],u=!1,e="https://leetcode.cn/problems/plus-one/",x="加一",d=["数组模拟","进位","从后向前"],o="用十进制数字数组表示一个非负整数，返回该整数加一后的数字数组。",l="从最低位开始处理进位；遇到小于九的数字时加一即可结束，全部为九才扩容。",r=["不能把整个数字转换为内置整数","连续的九都会变为零","最高位进位需要新建更长数组"],c=[{id:"carry-from-end",title:"逆序处理进位",kind:"最优",idea:"从末位寻找首个可直接加一的位置，经过的九置零。",steps:["从末位向前扫描","若当前位小于九则加一并返回","否则置零；全部处理完返回首位为一的新数组"],complexity:{time:"O(n)",space:"O(1) excluding output"},code:{java:`class Solution {
    public int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) { if (digits[index] < 9) { digits[index]++; return digits; } digits[index] = 0; }
        int[] answer = new int[digits.length + 1]; answer[0] = 1; return answer;
    }
}
`,kotlin:`class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (index in digits.lastIndex downTo 0) { if (digits[index] < 9) { digits[index]++; return digits }; digits[index] = 0 }
        return IntArray(digits.size + 1).also { it[0] = 1 }
    }
}
`,cpp:`class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int index = digits.size() - 1; index >= 0; --index) { if (digits[index] < 9) { ++digits[index]; return digits; } digits[index] = 0; }
        vector<int> answer(digits.size() + 1); answer[0] = 1; return answer;
    }
};
`}}],p={id:66,slug:i,titleEn:n,difficulty:"简单",category:t,officialTags:s,paidOnly:!1,sourceUrl:e,title:"加一",studyTags:d,summary:o,insight:l,pitfalls:r,solutions:c};export{t as category,p as default,g as difficulty,a as id,l as insight,s as officialTags,u as paidOnly,r as pitfalls,i as slug,c as solutions,e as sourceUrl,d as studyTags,o as summary,x as title,n as titleEn};
