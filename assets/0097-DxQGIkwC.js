const j=97,n="interleaving-string",s="Interleaving String",p="中等",i="动态规划",t=["字符串","动态规划"],g=!1,e="https://leetcode.cn/problems/interleaving-string/",o="交错字符串",l=["动态规划","字符串","滚动数组"],r="判断第三个字符串能否在保持前两个字符串各自字符顺序的前提下，由它们交错组成。",c="状态 (i,j) 只可能由取 s1 的最后一个字符或取 s2 的最后一个字符转移，一维数组即可滚动保存。",d=["总长度不等时可立即返回假","字符相同时两个转移都要保留","更新 dp 时 dp[j] 是上一行而 dp[j-1] 是当前行"],a=[{id:"one-dimensional-dp",title:"一维交错动态规划",kind:"最优",idea:"dp[j] 表示当前使用 s1 前 i 个和 s2 前 j 个字符时能否匹配。",steps:["先检查长度和","逐行逐列计算来自 s1 或 s2 的转移","返回 dp[s2.length]"],complexity:{time:"O(mn)",space:"O(n)"},code:{java:`class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false; boolean[] dp = new boolean[s2.length() + 1]; dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) for (int j = 0; j <= s2.length(); j++) { if (i == 0 && j == 0) continue; boolean first = i > 0 && dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); boolean second = j > 0 && dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1); dp[j] = first || second; }
        return dp[s2.length()];
    }
}
`,kotlin:`class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false; val dp = BooleanArray(s2.length + 1); dp[0] = true
        for (i in 0..s1.length) for (j in 0..s2.length) { if (i == 0 && j == 0) continue; val first = i > 0 && dp[j] && s1[i - 1] == s3[i + j - 1]; val second = j > 0 && dp[j - 1] && s2[j - 1] == s3[i + j - 1]; dp[j] = first || second }
        return dp[s2.length]
    }
}
`,cpp:`class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.size() + s2.size() != s3.size()) return false; vector<bool> dp(s2.size() + 1); dp[0] = true;
        for (int i = 0; i <= (int)s1.size(); ++i) for (int j = 0; j <= (int)s2.size(); ++j) { if (i == 0 && j == 0) continue; bool first = i > 0 && dp[j] && s1[i - 1] == s3[i + j - 1]; bool second = j > 0 && dp[j - 1] && s2[j - 1] == s3[i + j - 1]; dp[j] = first || second; } return dp[s2.size()];
    }
};
`}}],f={id:97,slug:n,titleEn:s,difficulty:"中等",category:i,officialTags:t,paidOnly:!1,sourceUrl:e,title:o,studyTags:l,summary:r,insight:c,pitfalls:d,solutions:a};export{i as category,f as default,p as difficulty,j as id,c as insight,t as officialTags,g as paidOnly,d as pitfalls,n as slug,a as solutions,e as sourceUrl,l as studyTags,r as summary,o as title,s as titleEn};
