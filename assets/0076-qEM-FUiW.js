const h=76,n="minimum-window-substring",t="Minimum Window Substring",o="困难",c="字符串",e=["哈希表","字符串","滑动窗口"],f=!1,i="https://leetcode.cn/problems/minimum-window-substring/",s="最小覆盖子串",r=["滑动窗口","字符欠账","最短合法区间"],d="在字符串 s 中寻找包含字符串 t 全部字符及其出现次数的最短连续子串，不存在时返回空字符串。",g="右端扩张用来偿还目标字符欠账；全部满足后持续移动左端，直到窗口即将失去合法性。",l=["重复字符需要满足对应次数","非目标字符可以进入窗口但不改变欠账","更新答案必须发生在窗口仍合法时"],a=[{id:"sliding-window-debt",title:"欠账计数滑动窗口",kind:"最优",idea:"计数数组保存仍需要的字符数量，missing 表示尚未匹配的目标字符总数。",steps:["统计 t 中字符并初始化 missing","右端字符若仍被需要则减少 missing","missing 为零时收缩左端并更新最短区间"],complexity:{time:"O(|s| + |t|)",space:"O(|Σ|)"},code:{java:`class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] need = new int[128];
        for (int index = 0; index < t.length(); index++) need[t.charAt(index)]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char added = s.charAt(right);
            if (need[added] > 0) missing--;
            need[added]--;
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                char removed = s.charAt(left++);
                need[removed]++;
                if (need[removed] > 0) missing++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
`,kotlin:`class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""
        val need = IntArray(128)
        for (char in t) need[char.code]++
        var missing = t.length
        var left = 0
        var bestStart = 0
        var bestLength = Int.MAX_VALUE
        for (right in s.indices) {
            val added = s[right].code
            if (need[added] > 0) missing--
            need[added]--
            while (missing == 0) {
                val length = right - left + 1
                if (length < bestLength) { bestLength = length; bestStart = left }
                val removed = s[left++].code
                need[removed]++
                if (need[removed] > 0) missing++
            }
        }
        return if (bestLength == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLength)
    }
}
`,cpp:`class Solution {
public:
    string minWindow(string s, string t) {
        if (t.size() > s.size()) return "";
        array<int, 128> need{};
        for (unsigned char value : t) ++need[value];
        int missing = t.size(), left = 0, bestStart = 0, bestLength = INT_MAX;
        for (int right = 0; right < (int)s.size(); ++right) {
            unsigned char added = s[right];
            if (need[added] > 0) --missing;
            --need[added];
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                unsigned char removed = s[left++];
                ++need[removed];
                if (need[removed] > 0) ++missing;
            }
        }
        return bestLength == INT_MAX ? "" : s.substr(bestStart, bestLength);
    }
};
`}}],m={id:76,slug:n,titleEn:t,difficulty:"困难",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:i,title:s,studyTags:r,summary:d,insight:g,pitfalls:l,solutions:a};export{c as category,m as default,o as difficulty,h as id,g as insight,e as officialTags,f as paidOnly,l as pitfalls,n as slug,a as solutions,i as sourceUrl,r as studyTags,d as summary,s as title,t as titleEn};
