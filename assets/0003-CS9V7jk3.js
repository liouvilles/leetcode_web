const h=3,t="longest-substring-without-repeating-characters",n="Longest Substring Without Repeating Characters",c="中等",f="字符串",s=["哈希表","字符串","滑动窗口"],u=!1,i="https://leetcode.cn/problems/longest-substring-without-repeating-characters/",e="无重复字符的最长子串",r=["不定长窗口","维护区间合法性","下标跳跃"],a="寻找字符串中不包含重复字符的最长连续片段，返回它的长度。",l="窗口右端持续扩展；一旦重复，只需让左端越过冲突字符上一次出现的位置。",o=["子串必须连续","左边界只能向右移动，不能被旧记录拉回","Java 与 Kotlin 的 Char 可直接作为哈希键"],g=[{id:"window-set",title:"集合维护窗口",kind:"基础",idea:"集合保存当前窗口内的字符；遇到重复时逐个移除左端字符。",steps:["尝试加入右端字符","若重复则收缩左端直至合法","更新最大窗口长度"],complexity:{time:"O(n)",space:"O(|Σ|)"},code:{java:`class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val window = HashSet<Char>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            while (s[right] in window) window.remove(s[left++])
            window.add(s[right])
            best = maxOf(best, right - left + 1)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> window;
        int left = 0, best = 0;
        for (int right = 0; right < (int)s.size(); ++right) {
            while (window.count(s[right])) window.erase(s[left++]);
            window.insert(s[right]);
            best = max(best, right - left + 1);
        }
        return best;
    }
};
`}},{id:"last-position",title:"记录最后位置",kind:"最优",idea:"保存每个字符最近出现的下标，让左边界一步跳过冲突点。",steps:["读取当前字符的最近位置","令 left = max(left, last + 1)","记录新位置并更新答案"],complexity:{time:"O(n)",space:"O(|Σ|)"},code:{java:`class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last.containsKey(c)) left = Math.max(left, last.get(c) + 1);
            last.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val last = HashMap<Char, Int>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            val c = s[right]
            left = maxOf(left, (last[c] ?: -1) + 1)
            last[c] = right
            best = maxOf(best, right - left + 1)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> last;
        int left = 0, best = 0;
        for (int right = 0; right < (int)s.size(); ++right) {
            if (last.count(s[right])) left = max(left, last[s[right]] + 1);
            last[s[right]] = right;
            best = max(best, right - left + 1);
        }
        return best;
    }
};
`}}],d={id:3,slug:t,titleEn:n,difficulty:"中等",category:"字符串",officialTags:s,paidOnly:!1,sourceUrl:i,title:e,studyTags:r,summary:a,insight:l,pitfalls:o,solutions:g};export{f as category,d as default,c as difficulty,h as id,l as insight,s as officialTags,u as paidOnly,o as pitfalls,t as slug,g as solutions,i as sourceUrl,r as studyTags,a as summary,e as title,n as titleEn};
