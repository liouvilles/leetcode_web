const o=28,n="find-the-index-of-the-first-occurrence-in-a-string",t="Find the Index of the First Occurrence in a String",h="简单",g="字符串",e=["双指针","字符串","字符串匹配","Z Algorithm","Knuth–Morris–Pratt Algorithm","Boyer–Moore String-Search Algorithm"],u=!1,i="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/",s="找出字符串中第一个匹配项的下标",r=["字符串匹配","滑动起点","逐字符比较"],a="返回模式串在文本串中第一次完整出现的起始下标，不存在时返回 -1。",l="枚举所有仍容得下模式串的起点，并逐字符验证；首个完全匹配的位置就是答案。",c=["起点最多枚举到 n-m","模式串比文本长时直接不存在","题目要求第一次出现的位置"],d=[{id:"naive-matching",title:"枚举起点匹配",kind:"最优",idea:"从左到右检查每个候选起点，发现完整匹配立即返回。",steps:["枚举 start 从 0 到 n-m","比较 needle 的每个字符","全部相等时返回 start，否则最终返回 -1"],complexity:{time:"O(nm)",space:"O(1)"},code:{java:`class Solution {
    public int strStr(String haystack, String needle) {
        for (int start = 0; start + needle.length() <= haystack.length(); start++) {
            int index = 0;
            while (index < needle.length() && haystack.charAt(start + index) == needle.charAt(index)) index++;
            if (index == needle.length()) return start;
        }
        return -1;
    }
}
`,kotlin:`class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (start in 0..haystack.length - needle.length) {
            var index = 0
            while (index < needle.length && haystack[start + index] == needle[index]) index++
            if (index == needle.length) return start
        }
        return -1
    }
}
`,cpp:`class Solution {
public:
    int strStr(string haystack, string needle) {
        for (int start = 0; start + (int)needle.size() <= (int)haystack.size(); ++start) {
            int index = 0;
            while (index < (int)needle.size() && haystack[start + index] == needle[index]) ++index;
            if (index == (int)needle.size()) return start;
        }
        return -1;
    }
};
`}}],f={id:28,slug:n,titleEn:t,difficulty:"简单",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:i,title:s,studyTags:r,summary:a,insight:l,pitfalls:c,solutions:d};export{g as category,f as default,h as difficulty,o as id,l as insight,e as officialTags,u as paidOnly,c as pitfalls,n as slug,d as solutions,i as sourceUrl,r as studyTags,a as summary,s as title,t as titleEn};
