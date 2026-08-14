const o=5,t="longest-palindromic-substring",n="Longest Palindromic Substring",f="中等",e="动态规划",s=["双指针","字符串","动态规划","Manacher"],d=!1,i="https://leetcode.cn/problems/longest-palindromic-substring/",r="最长回文子串",l=["中心扩展","奇偶中心","区间更新"],g="在给定字符串中寻找长度最大的连续回文片段，并返回其中任意一个最长答案。",c="每个回文串都能由一个字符中心或两个字符之间的中心向两侧同步扩展得到。",a=["子串必须连续","需要分别处理奇数长度和偶数长度中心","多个最长答案同时存在时返回任意一个即可"],h=[{id:"expand-around-center",title:"中心扩展",kind:"最优",idea:"枚举 2n-1 个可能的回文中心，向两侧扩展并记录最长边界。",steps:["对每个位置尝试单字符中心","再尝试相邻双字符中心","仅在得到更长回文时更新左右边界"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for (int center = 0; center < s.length(); center++) {
            int length = Math.max(expand(s, center, center), expand(s, center, center + 1));
            if (length > right - left + 1) {
                left = center - (length - 1) / 2;
                right = center + length / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
`,kotlin:`class Solution {
    fun longestPalindrome(s: String): String {
        var bestLeft = 0
        var bestRight = 0
        for (center in s.indices) {
            val length = maxOf(expand(s, center, center), expand(s, center, center + 1))
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2
                bestRight = center + length / 2
            }
        }
        return s.substring(bestLeft, bestRight + 1)
    }

    private fun expand(s: String, startLeft: Int, startRight: Int): Int {
        var left = startLeft
        var right = startRight
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }
}
`,cpp:`class Solution {
    int expand(const string& s, int left, int right) {
        while (left >= 0 && right < (int)s.size() && s[left] == s[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
public:
    string longestPalindrome(string s) {
        int bestLeft = 0, bestRight = 0;
        for (int center = 0; center < (int)s.size(); ++center) {
            int length = max(expand(s, center, center), expand(s, center, center + 1));
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2;
                bestRight = center + length / 2;
            }
        }
        return s.substr(bestLeft, bestRight - bestLeft + 1);
    }
};
`}}],u={id:5,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:i,title:r,studyTags:l,summary:g,insight:c,pitfalls:a,solutions:h};export{e as category,u as default,f as difficulty,o as id,c as insight,s as officialTags,d as paidOnly,a as pitfalls,t as slug,h as solutions,i as sourceUrl,l as studyTags,g as summary,r as title,n as titleEn};
