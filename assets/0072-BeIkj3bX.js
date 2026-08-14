const l=72,n="edit-distance",t="Edit Distance",w="中等",s="动态规划",i=["字符串","动态规划"],g=!1,e="https://leetcode.cn/problems/edit-distance/",d="编辑距离",o=["二维动态规划","字符串转换","前缀状态"],r="通过插入、删除或替换单个字符，把一个字符串转换成另一个字符串，求最少操作次数。",c="比较两个前缀末字符；相同时继承左上状态，不同时从插入、删除、替换三种前驱中取最小值再加一。",f=["空字符串与另一前缀的距离等于前缀长度","替换来自左上状态","插入和删除来自同一行左侧与上一行同列"],a=[{id:"prefix-dp",title:"前缀编辑动态规划",kind:"最优",idea:"二维表记录任意两个前缀之间的最短编辑距离。",steps:["初始化空前缀边界","末字符相同则复制左上值","否则取三个相邻状态最小值加一"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int first = 0; first <= word1.length(); first++) distance[first][0] = first;
        for (int second = 0; second <= word2.length(); second++) distance[0][second] = second;
        for (int first = 1; first <= word1.length(); first++) for (int second = 1; second <= word2.length(); second++) {
            if (word1.charAt(first - 1) == word2.charAt(second - 1)) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + Math.min(distance[first - 1][second - 1], Math.min(distance[first - 1][second], distance[first][second - 1]));
        }
        return distance[word1.length()][word2.length()];
    }
}
`,kotlin:`class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val distance = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (first in 0..word1.length) distance[first][0] = first
        for (second in 0..word2.length) distance[0][second] = second
        for (first in 1..word1.length) for (second in 1..word2.length) distance[first][second] = if (word1[first - 1] == word2[second - 1]) distance[first - 1][second - 1] else 1 + minOf(distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1])
        return distance[word1.length][word2.length]
    }
}
`,cpp:`class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> distance(word1.size() + 1, vector<int>(word2.size() + 1));
        for (int first = 0; first <= (int)word1.size(); ++first) distance[first][0] = first;
        for (int second = 0; second <= (int)word2.size(); ++second) distance[0][second] = second;
        for (int first = 1; first <= (int)word1.size(); ++first) for (int second = 1; second <= (int)word2.size(); ++second) {
            if (word1[first - 1] == word2[second - 1]) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + min({distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1]});
        }
        return distance[word1.size()][word2.size()];
    }
};
`}}],h={id:72,slug:n,titleEn:t,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:e,title:d,studyTags:o,summary:r,insight:c,pitfalls:f,solutions:a};export{s as category,h as default,w as difficulty,l as id,c as insight,i as officialTags,g as paidOnly,f as pitfalls,n as slug,a as solutions,e as sourceUrl,o as studyTags,r as summary,d as title,t as titleEn};
