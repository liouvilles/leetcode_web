const c=125,t="valid-palindrome",e="Valid Palindrome",g="简单",f="字符串",i=["双指针","字符串"],u=!1,n="https://leetcode.cn/problems/valid-palindrome/",r="验证回文串",l=["双指针","字符过滤","忽略大小写"],s="忽略非字母数字字符和字母大小写后，判断字符串是否为回文。",a="左右指针跳过无关字符，仅比较下一对有效字符的小写形式即可，无需构造新字符串。",o=["数字也属于有效字符","比较前需要统一大小写","全由标点组成的字符串视为空回文串"],h=[{id:"filtered-two-pointers",title:"过滤式双指针",kind:"最优",idea:"从两端向中间移动，按需跳过非字母数字字符。",steps:["左指针跳到下一个有效字符","右指针跳到上一个有效字符","比较忽略大小写后的字符并继续收缩"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
        }
        return true;
    }
}
`,kotlin:`class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0; var right = s.lastIndex
        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) left++
            while (left < right && !s[right].isLetterOrDigit()) right--
            if (s[left++].lowercaseChar() != s[right--].lowercaseChar()) return false
        }
        return true
    }
}
`,cpp:`class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0, right = s.size() - 1;
        while (left < right) {
            while (left < right && !isalnum((unsigned char)s[left])) ++left;
            while (left < right && !isalnum((unsigned char)s[right])) --right;
            if (tolower((unsigned char)s[left++]) != tolower((unsigned char)s[right--])) return false;
        }
        return true;
    }
};
`}}],d={id:125,slug:t,titleEn:e,difficulty:"简单",category:"字符串",officialTags:i,paidOnly:!1,sourceUrl:n,title:r,studyTags:l,summary:s,insight:a,pitfalls:o,solutions:h};export{f as category,d as default,g as difficulty,c as id,a as insight,i as officialTags,u as paidOnly,o as pitfalls,t as slug,h as solutions,n as sourceUrl,l as studyTags,s as summary,r as title,e as titleEn};
