const h=438,n="find-all-anagrams-in-a-string",t="Find All Anagrams in a String",c="中等",p="字符串",i=["哈希表","字符串","滑动窗口"],w=!1,r="https://leetcode.cn/problems/find-all-anagrams-in-a-string/",s="找到字符串中所有字母异位词",a=["定长滑动窗口","字符计数","异位词"],e="返回字符串 s 中所有与 p 字母异位的连续子串起始下标。",g="长度固定为 p.length 的窗口若与 p 的 26 个字符频次完全相同，就是一个答案。",l=["窗口长度必须固定","右端加入与左端移除要同步更新计数","p 比 s 长时直接返回空列表"],o=[{id:"fixed-window-counts",title:"定长计数窗口",kind:"最优",idea:"维护目标频次和当前窗口频次，在每次窗口成形时比较。",steps:["统计 p 的字符频次","右端字符加入窗口","超长时移除 left，长度相等时比较数组"],complexity:{time:"O(26n)",space:"O(1)"},code:{java:`class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>(); if (p.length() > s.length()) return answer;
        int[] target = new int[26], window = new int[26]; for (char value : p.toCharArray()) target[value - 'a']++;
        for (int right = 0; right < s.length(); right++) { window[s.charAt(right) - 'a']++; if (right >= p.length()) window[s.charAt(right - p.length()) - 'a']--; if (right >= p.length() - 1 && Arrays.equals(target, window)) answer.add(right - p.length() + 1); }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()
        val target = IntArray(26); val window = IntArray(26); for (value in p) target[value - 'a']++
        val answer = ArrayList<Int>()
        for (right in s.indices) { window[s[right] - 'a']++; if (right >= p.length) window[s[right - p.length] - 'a']--; if (right >= p.length - 1 && target.contentEquals(window)) answer.add(right - p.length + 1) }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (p.size() > s.size()) return {};
        array<int, 26> target{}, window{}; for (char value : p) ++target[value - 'a']; vector<int> answer;
        for (int right = 0; right < (int)s.size(); ++right) { ++window[s[right] - 'a']; if (right >= (int)p.size()) --window[s[right - p.size()] - 'a']; if (right >= (int)p.size() - 1 && target == window) answer.push_back(right - p.size() + 1); }
        return answer;
    }
};
`}}],d={id:438,slug:n,titleEn:t,difficulty:"中等",category:"字符串",officialTags:i,paidOnly:!1,sourceUrl:r,title:s,studyTags:a,summary:e,insight:g,pitfalls:l,solutions:o};export{p as category,d as default,c as difficulty,h as id,g as insight,i as officialTags,w as paidOnly,l as pitfalls,n as slug,o as solutions,r as sourceUrl,a as studyTags,e as summary,s as title,t as titleEn};
