const a=91,n="decode-ways",e="Decode Ways",l="中等",i="动态规划",r=["字符串","动态规划"],v=!1,s="https://leetcode.cn/problems/decode-ways/",o="解码方法",t=["线性动态规划","两位转移","零的处理"],u="数字 1 到 26 分别映射字母，计算给定数字字符串有多少种完整解码方式。",c="当前位置可以由合法的单个数字接在前一前缀后，也可以由合法的两位数字接在前两位前缀后。",d=["字符 0 不能单独解码","两位数必须在 10 到 26 之间","以零开头的字符串没有解码方式"],p=[{id:"rolling-dp",title:"滚动前缀 DP",kind:"最优",idea:"维护前两个前缀的解码数量，并根据一位和两位合法性累加当前值。",steps:["空前缀计数为一","当前字符非零时加入 previous","两位数合法时加入 beforePrevious"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < s.length(); index++) {
            int current = s.charAt(index) == '0' ? 0 : previous;
            int pair = (s.charAt(index - 1) - '0') * 10 + s.charAt(index) - '0';
            if (pair >= 10 && pair <= 26) current += beforePrevious;
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
`,kotlin:`class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        var beforePrevious = 1; var previous = 1
        for (index in 1 until s.length) { var current = if (s[index] == '0') 0 else previous; val pair = (s[index - 1] - '0') * 10 + (s[index] - '0'); if (pair in 10..26) current += beforePrevious; beforePrevious = previous; previous = current }
        return previous
    }
}
`,cpp:`class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < (int)s.size(); ++index) { int current = s[index] == '0' ? 0 : previous; int pair = (s[index - 1] - '0') * 10 + s[index] - '0'; if (pair >= 10 && pair <= 26) current += beforePrevious; beforePrevious = previous; previous = current; }
        return previous;
    }
};
`}}],f={id:91,slug:n,titleEn:e,difficulty:"中等",category:i,officialTags:r,paidOnly:!1,sourceUrl:s,title:o,studyTags:t,summary:u,insight:c,pitfalls:d,solutions:p};export{i as category,f as default,l as difficulty,a as id,c as insight,r as officialTags,v as paidOnly,d as pitfalls,n as slug,p as solutions,s as sourceUrl,t as studyTags,u as summary,o as title,e as titleEn};
