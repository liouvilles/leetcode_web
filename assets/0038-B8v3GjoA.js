const l=38,n="count-and-say",t="Count and Say",u="中等",w="字符串",e=["字符串"],g=!1,r="https://leetcode.cn/problems/count-and-say/",s="外观数列",a=["游程编码","字符串模拟","迭代"],i="从字符串“1”开始，反复描述上一项中连续相同字符的数量和值，求第 n 项。",o="每一轮都是对上一字符串做一次游程编码：统计连续段长度，再追加长度和字符。",d=["描述的是连续分组而非字符总频次","第一项直接是 1","每轮末尾的连续段也要写入"],c=[{id:"run-length-iteration",title:"逐轮游程编码",kind:"最优",idea:"从第一项开始迭代 n-1 次，每次压缩连续相同字符段。",steps:["answer 初始化为 1","扫描连续相同字符的右边界","追加段长和字符并进入下一轮"],complexity:{time:"O(Ln)",space:"O(Ln)"},code:{java:`class Solution {
    public String countAndSay(int n) {
        String answer = "1";
        for (int round = 1; round < n; round++) {
            StringBuilder next = new StringBuilder();
            for (int start = 0; start < answer.length();) { int end = start + 1; while (end < answer.length() && answer.charAt(end) == answer.charAt(start)) end++; next.append(end - start).append(answer.charAt(start)); start = end; }
            answer = next.toString();
        }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun countAndSay(n: Int): String {
        var answer = "1"
        repeat(n - 1) { val next = StringBuilder(); var start = 0; while (start < answer.length) { var end = start + 1; while (end < answer.length && answer[end] == answer[start]) end++; next.append(end - start).append(answer[start]); start = end }; answer = next.toString() }
        return answer
    }
}
`,cpp:`class Solution {
public:
    string countAndSay(int n) {
        string answer = "1";
        for (int round = 1; round < n; ++round) { string next; for (int start = 0; start < (int)answer.size();) { int end = start + 1; while (end < (int)answer.size() && answer[end] == answer[start]) ++end; next += to_string(end - start); next += answer[start]; start = end; } answer = next; }
        return answer;
    }
};
`}}],p={id:38,slug:n,titleEn:t,difficulty:"中等",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:r,title:s,studyTags:a,summary:i,insight:o,pitfalls:d,solutions:c};export{w as category,p as default,u as difficulty,l as id,o as insight,e as officialTags,g as paidOnly,d as pitfalls,n as slug,c as solutions,r as sourceUrl,a as studyTags,i as summary,s as title,t as titleEn};
