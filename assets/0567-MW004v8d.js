const f=567,n="permutation-in-string",t="Permutation in String",d="中等",g="字符串",e=["哈希表","双指针","字符串","滑动窗口"],u=!1,i="https://leetcode.cn/problems/permutation-in-string/",s="字符串的排列",l=["定长滑动窗口","频次差","排列匹配"],o="判断字符串 s2 是否包含一个连续子串，它是字符串 s1 的某种排列。",r="排列长度固定且字符频次不变，维护与 s1 等长窗口的 26 个计数即可判断。",a=["s1 比 s2 长时必然失败","窗口每右移一步要同时加入和移除字符","只比较字符集合会漏掉重复次数"],c=[{id:"fixed-frequency-window",title:"定长频次数组",kind:"最优",idea:"先建立第一个窗口，再逐步滑动并比较频次。",steps:["统计 s1 与 s2 首窗口频次","每轮先检查数组是否相等","加入新右端并移除旧左端"],complexity:{time:"O(26n)",space:"O(1)"},code:{java:`class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] target = new int[26], window = new int[26];
        for (int index = 0; index < s1.length(); index++) { target[s1.charAt(index) - 'a']++; window[s2.charAt(index) - 'a']++; }
        for (int left = 0; left <= s2.length() - s1.length(); left++) { if (Arrays.equals(target, window)) return true; int next = left + s1.length(); if (next < s2.length()) { window[s2.charAt(left) - 'a']--; window[s2.charAt(next) - 'a']++; } }
        return false;
    }
}
`,kotlin:`class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val target = IntArray(26); val window = IntArray(26)
        for (index in s1.indices) { target[s1[index] - 'a']++; window[s2[index] - 'a']++ }
        for (left in 0..s2.length - s1.length) { if (target.contentEquals(window)) return true; val next = left + s1.length; if (next < s2.length) { window[s2[left] - 'a']--; window[s2[next] - 'a']++ } }
        return false
    }
}
`,cpp:`class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.size() > s2.size()) return false;
        array<int, 26> target{}, window{};
        for (int index = 0; index < (int)s1.size(); ++index) { ++target[s1[index] - 'a']; ++window[s2[index] - 'a']; }
        for (int left = 0; left <= (int)s2.size() - (int)s1.size(); ++left) { if (target == window) return true; int next = left + s1.size(); if (next < (int)s2.size()) { --window[s2[left] - 'a']; ++window[s2[next] - 'a']; } }
        return false;
    }
};
`}}],w={id:567,slug:n,titleEn:t,difficulty:"中等",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:i,title:s,studyTags:l,summary:o,insight:r,pitfalls:a,solutions:c};export{g as category,w as default,d as difficulty,f as id,r as insight,e as officialTags,u as paidOnly,a as pitfalls,n as slug,c as solutions,i as sourceUrl,l as studyTags,o as summary,s as title,t as titleEn};
