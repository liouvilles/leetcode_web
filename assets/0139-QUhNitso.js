const p=139,n="word-break",s="Word Break",b="中等",t="动态规划",e=["数组","哈希表","字符串","动态规划","字典树","记忆化搜索","暴力搜索"],u=!1,o="https://leetcode.cn/problems/word-break/",i="单词拆分",r=["前缀动态规划","字符串切分","字典集合"],d="判断字符串能否被拆分成一个或多个字典中的单词，字典单词可以重复使用。",l="令 dp[i] 表示长度为 i 的前缀能否拆分；只要存在可拆分前缀 j 且 s[j..i) 在字典中，dp[i] 就成立。",a=["单词允许重复使用","状态下标表示前缀长度而不是字符下标","只有 dp[start] 为真时才需要检查后续子串"],c=[{id:"prefix-dp",title:"前缀可达动态规划",kind:"最优",idea:"从每个已经可拆分的前缀出发，检查它与后续位置组成的单词是否在字典中。",steps:["把字典转换为哈希集合","初始化空前缀 dp[0] 为真","枚举结尾和切分点更新 dp[end]"],complexity:{time:"O(n³)",space:"O(n + |dict|)"},code:{java:`class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (possible[start] && words.contains(s.substring(start, end))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.length()];
    }
}
`,kotlin:`class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val words = wordDict.toHashSet()
        val possible = BooleanArray(s.length + 1)
        possible[0] = true
        for (end in 1..s.length) {
            for (start in 0 until end) {
                if (possible[start] && s.substring(start, end) in words) {
                    possible[end] = true
                    break
                }
            }
        }
        return possible[s.length]
    }
}
`,cpp:`class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> words(wordDict.begin(), wordDict.end());
        vector<bool> possible(s.size() + 1);
        possible[0] = true;
        for (int end = 1; end <= (int)s.size(); ++end) {
            for (int start = 0; start < end; ++start) {
                if (possible[start] && words.count(s.substr(start, end - start))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.size()];
    }
};
`}}],g={id:139,slug:n,titleEn:s,difficulty:"中等",category:t,officialTags:e,paidOnly:!1,sourceUrl:o,title:i,studyTags:r,summary:d,insight:l,pitfalls:a,solutions:c};export{t as category,g as default,b as difficulty,p as id,l as insight,e as officialTags,u as paidOnly,a as pitfalls,n as slug,c as solutions,o as sourceUrl,r as studyTags,d as summary,i as title,s as titleEn};
