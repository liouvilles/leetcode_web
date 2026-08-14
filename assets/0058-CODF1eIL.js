const r=58,n="length-of-last-word",t="Length of Last Word",h="简单",g="字符串",e=["字符串"],x=!1,i="https://leetcode.cn/problems/length-of-last-word/",s="最后一个单词的长度",l=["反向扫描","字符串","空格跳过"],d="给定由单词和空格组成的字符串，返回最后一个单词包含的字符数量。",o="从末尾先跳过尾随空格，再连续统计非空格字符，避免拆分整个字符串。",c=["字符串末尾可能有多个空格","单词之间也可能有多个空格","只统计最后一段非空格字符"],a=[{id:"reverse-scan",title:"从尾部线性扫描",kind:"最优",idea:"定位最后一个单词末尾后向前计数直到空格或开头。",steps:["index 从末尾开始跳过空格","持续向前统计非空格字符","返回计数"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1; while (index >= 0 && s.charAt(index) == ' ') index--;
        int length = 0; while (index >= 0 && s.charAt(index) != ' ') { length++; index--; }
        return length;
    }
}
`,kotlin:`class Solution {
    fun lengthOfLastWord(s: String): Int {
        var index = s.lastIndex; while (index >= 0 && s[index] == ' ') index--
        var length = 0; while (index >= 0 && s[index] != ' ') { length++; index-- }
        return length
    }
}
`,cpp:`class Solution {
public:
    int lengthOfLastWord(string s) {
        int index = s.size() - 1; while (index >= 0 && s[index] == ' ') --index;
        int length = 0; while (index >= 0 && s[index] != ' ') { ++length; --index; }
        return length;
    }
};
`}}],u={id:58,slug:n,titleEn:t,difficulty:"简单",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:i,title:s,studyTags:l,summary:d,insight:o,pitfalls:c,solutions:a};export{g as category,u as default,h as difficulty,r as id,o as insight,e as officialTags,x as paidOnly,c as pitfalls,n as slug,a as solutions,i as sourceUrl,l as studyTags,d as summary,s as title,t as titleEn};
