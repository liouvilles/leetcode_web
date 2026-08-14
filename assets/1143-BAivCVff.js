const f=1143,n="longest-common-subsequence",t="Longest Common Subsequence",d="中等",e="动态规划",i=["字符串","动态规划","最长公共子序列"],u=!1,s="https://leetcode.cn/problems/longest-common-subsequence/",o="最长公共子序列",l=["二维动态规划","字符串子序列","前缀状态"],c="求两个字符串共同子序列的最大长度，子序列保留相对顺序但不要求连续。",r="末字符相同就接在两个更短前缀的最优子序列后；不同则至少舍弃其中一个末字符并取较优结果。",g=["子序列不要求连续","字符相同时转移自左上角加一","字符不同时取上方与左方最大值"],h=[{id:"prefix-dp",title:"双前缀动态规划",kind:"最优",idea:"dp[i][j] 表示两个长度为 i、j 的前缀的最长公共子序列长度。",steps:["空前缀边界保持零","末字符相同则 dp[i-1][j-1]+1","否则 max(dp[i-1][j],dp[i][j-1])"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int longestCommonSubsequence(String first, String second) {
        int[][] length = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) for (int j = 1; j <= second.length(); j++) length[i][j] = first.charAt(i - 1) == second.charAt(j - 1) ? length[i - 1][j - 1] + 1 : Math.max(length[i - 1][j], length[i][j - 1]);
        return length[first.length()][second.length()];
    }
}
`,kotlin:`class Solution {
    fun longestCommonSubsequence(first: String, second: String): Int {
        val length = Array(first.length + 1) { IntArray(second.length + 1) }
        for (i in 1..first.length) for (j in 1..second.length) length[i][j] = if (first[i - 1] == second[j - 1]) length[i - 1][j - 1] + 1 else maxOf(length[i - 1][j], length[i][j - 1])
        return length[first.length][second.length]
    }
}
`,cpp:`class Solution {
public:
    int longestCommonSubsequence(string first, string second) {
        vector<vector<int>> length(first.size() + 1, vector<int>(second.size() + 1));
        for (int i = 1; i <= (int)first.size(); ++i) for (int j = 1; j <= (int)second.size(); ++j) length[i][j] = first[i - 1] == second[j - 1] ? length[i - 1][j - 1] + 1 : max(length[i - 1][j], length[i][j - 1]);
        return length[first.size()][second.size()];
    }
};
`}}],a={id:1143,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:i,paidOnly:!1,sourceUrl:s,title:o,studyTags:l,summary:c,insight:r,pitfalls:g,solutions:h};export{e as category,a as default,d as difficulty,f as id,r as insight,i as officialTags,u as paidOnly,g as pitfalls,n as slug,h as solutions,s as sourceUrl,l as studyTags,c as summary,o as title,t as titleEn};
