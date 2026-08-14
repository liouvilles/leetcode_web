const p=131,t="palindrome-partitioning",n="Palindrome Partitioning",u="中等",r="动态规划",s=["字符串","动态规划","回溯"],g=!1,a="https://leetcode.cn/problems/palindrome-partitioning/",i="分割回文串",e=["回溯","回文判断","字符串分割"],o="把字符串分割为若干连续子串，返回所有使每个子串都是回文串的分割方案。",l="从当前起点枚举下一段的终点，只有该段为回文时才递归处理剩余后缀。",c=["必须覆盖原字符串的全部字符","单字符总是回文","记录方案时需要复制当前路径"],d=[{id:"palindrome-backtracking",title:"枚举回文前缀回溯",kind:"最优",idea:"递归选择每个后缀的一个回文前缀，走到字符串末尾即形成方案。",steps:["枚举 end 从 start 到末尾","双指针检查 s[start..end] 是否回文","选择子串、递归 end+1、撤销选择"],complexity:{time:"O(n·2^n)",space:"O(n)"},code:{java:`class Solution {
    public List<List<String>> partition(String s) { List<List<String>> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int start, List<String> path, List<List<String>> answer) { if (start == s.length()) { answer.add(new ArrayList<>(path)); return; } for (int end = start; end < s.length(); end++) if (isPalindrome(s, start, end)) { path.add(s.substring(start, end + 1)); backtrack(s, end + 1, path, answer); path.remove(path.size() - 1); } }
    private boolean isPalindrome(String s, int left, int right) { while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false; return true; }
}
`,kotlin:`class Solution {
    fun partition(s: String): List<List<String>> { val answer = mutableListOf<List<String>>(); val path = mutableListOf<String>(); fun palindrome(start: Int, endValue: Int): Boolean { var left = start; var right = endValue; while (left < right) if (s[left++] != s[right--]) return false; return true }; fun backtrack(start: Int) { if (start == s.length) { answer.add(path.toList()); return }; for (endValue in start until s.length) if (palindrome(start, endValue)) { path.add(s.substring(start, endValue + 1)); backtrack(endValue + 1); path.removeAt(path.lastIndex) } }; backtrack(0); return answer }
}
`,cpp:`class Solution {
    bool palindrome(const string& s, int left, int right) { while (left < right) if (s[left++] != s[right--]) return false; return true; }
    void backtrack(const string& s, int start, vector<string>& path, vector<vector<string>>& answer) { if (start == (int)s.size()) { answer.push_back(path); return; } for (int end = start; end < (int)s.size(); ++end) if (palindrome(s, start, end)) { path.push_back(s.substr(start, end - start + 1)); backtrack(s, end + 1, path, answer); path.pop_back(); } }
public:
    vector<vector<string>> partition(string s) { vector<vector<string>> answer; vector<string> path; backtrack(s, 0, path, answer); return answer; }
};
`}}],h={id:131,slug:t,titleEn:n,difficulty:"中等",category:r,officialTags:s,paidOnly:!1,sourceUrl:a,title:i,studyTags:e,summary:o,insight:l,pitfalls:c,solutions:d};export{r as category,h as default,u as difficulty,p as id,l as insight,s as officialTags,g as paidOnly,c as pitfalls,t as slug,d as solutions,a as sourceUrl,e as studyTags,o as summary,i as title,n as titleEn};
