const l=151,n="reverse-words-in-a-string",s="Reverse Words in a String",g="中等",w="字符串",e=["双指针","字符串"],p=!1,r="https://leetcode.cn/problems/reverse-words-in-a-string/",t="反转字符串中的单词",i=["字符串解析","空白压缩","逆序拼接"],o="反转字符串中单词的顺序，结果仅保留单词间一个空格，并去除首尾与多余空格。",d="按一个或多个空白分割出有效单词，再从后向前用单空格连接即可。",a=["需要先去除首尾空格","多个连续空格应视为一个分隔符","单词内部字符顺序不反转"],c=[{id:"split-reverse",title:"分词后逆序",kind:"最优",idea:"规范化空白并逆序拼接单词数组。",steps:["trim 去除首尾空白","按连续空白拆分","从末尾向前用单空格连接"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\\\s+"); StringBuilder answer = new StringBuilder();
        for (int index = words.length - 1; index >= 0; index--) { if (answer.length() > 0) answer.append(' '); answer.append(words[index]); }
        return answer.toString();
    }
}
`,kotlin:`class Solution {
    fun reverseWords(s: String): String = s.trim().split(Regex("\\\\s+")).asReversed().joinToString(" ")
}
`,cpp:`class Solution {
public:
    string reverseWords(string s) {
        stringstream stream(s); vector<string> words; string word; while (stream >> word) words.push_back(word);
        reverse(words.begin(), words.end()); string answer;
        for (int index = 0; index < (int)words.size(); ++index) { if (index) answer.push_back(' '); answer += words[index]; }
        return answer;
    }
};
`}}],u={id:151,slug:n,titleEn:s,difficulty:"中等",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:r,title:t,studyTags:i,summary:o,insight:d,pitfalls:a,solutions:c};export{w as category,u as default,g as difficulty,l as id,d as insight,e as officialTags,p as paidOnly,a as pitfalls,n as slug,c as solutions,r as sourceUrl,i as studyTags,o as summary,t as title,s as titleEn};
