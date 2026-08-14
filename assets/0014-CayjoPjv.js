const m=14,t="longest-common-prefix",n="Longest Common Prefix",a="简单",i="树与高级结构",s=["数组","字符串","字典树"],x=!1,e="https://leetcode.cn/problems/longest-common-prefix/",r="最长公共前缀",o=["纵向扫描","字符串数组","边界"],c="返回字符串数组中所有字符串共有的最长开头片段，不存在时返回空串。",f="以第一个字符串为基准逐列比较；任一字符串结束或字符不同，当前位置就是公共前缀终点。",l=["最短字符串限制了最大前缀长度","数组至少含一个字符串","空字符串会立即得到空前缀"],d=[{id:"vertical-scan",title:"逐列纵向扫描",kind:"最优",idea:"对基准串的每个字符检查所有其他字符串同位置字符。",steps:["遍历第一个字符串的字符下标","检查每个其他字符串是否越界或不相等","首次失败返回基准串前缀，否则返回整个基准串"],complexity:{time:"O(total characters checked)",space:"O(1)"},code:{java:`class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int index = 0; index < first.length(); index++) for (int item = 1; item < strs.length; item++) if (index == strs[item].length() || strs[item].charAt(index) != first.charAt(index)) return first.substring(0, index);
        return first;
    }
}
`,kotlin:`class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val first = strs[0]
        for (index in first.indices) for (item in 1 until strs.size) if (index == strs[item].length || strs[item][index] != first[index]) return first.substring(0, index)
        return first
    }
}
`,cpp:`class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        const string& first = strs[0];
        for (int index = 0; index < (int)first.size(); ++index) for (int item = 1; item < (int)strs.size(); ++item) if (index == (int)strs[item].size() || strs[item][index] != first[index]) return first.substr(0, index);
        return first;
    }
};
`}}],g={id:14,slug:t,titleEn:n,difficulty:"简单",category:i,officialTags:s,paidOnly:!1,sourceUrl:e,title:r,studyTags:o,summary:c,insight:f,pitfalls:l,solutions:d};export{i as category,g as default,a as difficulty,m as id,f as insight,s as officialTags,x as paidOnly,l as pitfalls,t as slug,d as solutions,e as sourceUrl,o as studyTags,c as summary,r as title,n as titleEn};
