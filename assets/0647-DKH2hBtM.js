const g=647,t="palindromic-substrings",n="Palindromic Substrings",d="中等",e="动态规划",s=["双指针","字符串","动态规划"],f=!1,r="https://leetcode.cn/problems/palindromic-substrings/",i="回文子串",c=["中心扩展","回文计数","奇偶中心"],a="统计字符串中所有回文连续子串的数量，不同起止位置即视为不同子串。",o="每个回文子串都有唯一中心，枚举单字符中心和字符间隙中心并向外扩展即可恰好计数一次。",l=["相同文本但位置不同的子串分别计数","偶数长度回文中心在两个字符之间","每成功扩展一层就新增一个回文子串"],u=[{id:"expand-centers",title:"枚举 2n-1 个中心",kind:"最优",idea:"对每个位置分别扩展奇数与偶数回文并累计成功次数。",steps:["遍历每个字符位置","从 (center,center) 扩展奇数回文","从 (center,center+1) 扩展偶数回文"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public int countSubstrings(String s) {
        int answer = 0; for (int center = 0; center < s.length(); center++) answer += expand(s, center, center) + expand(s, center, center + 1); return answer;
    }
    private int expand(String s, int left, int right) { int count = 0; while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++; return count; }
}
`,kotlin:`class Solution {
    fun countSubstrings(s: String): Int { var answer = 0; for (center in s.indices) answer += expand(s, center, center) + expand(s, center, center + 1); return answer }
    private fun expand(s: String, startLeft: Int, startRight: Int): Int { var left = startLeft; var right = startRight; var count = 0; while (left >= 0 && right < s.length && s[left] == s[right]) { count++; left--; right++ }; return count }
}
`,cpp:`class Solution {
    int expand(const string& s, int left, int right) { int count = 0; while (left >= 0 && right < (int)s.size() && s[left] == s[right]) { ++count; --left; ++right; } return count; }
public:
    int countSubstrings(string s) { int answer = 0; for (int center = 0; center < (int)s.size(); ++center) answer += expand(s, center, center) + expand(s, center, center + 1); return answer; }
};
`}}],p={id:647,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:r,title:i,studyTags:c,summary:a,insight:o,pitfalls:l,solutions:u};export{e as category,p as default,d as difficulty,g as id,o as insight,s as officialTags,f as paidOnly,l as pitfalls,t as slug,u as solutions,r as sourceUrl,c as studyTags,a as summary,i as title,n as titleEn};
