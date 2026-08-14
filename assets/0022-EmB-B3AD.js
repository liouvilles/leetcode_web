const h=22,n="generate-parentheses",t="Generate Parentheses",d="中等",e="动态规划",a=["字符串","动态规划","回溯","Bracket Sequences"],u=!1,s="https://leetcode.cn/problems/generate-parentheses/",i="括号生成",r=["回溯","合法前缀","剪枝"],p="给定括号对数 n，生成所有由 n 对圆括号组成且整体合法的不同字符串。",o="构造过程中只要保证右括号使用数不超过左括号，当前前缀就仍有机会扩展成合法答案。",l=["左括号和右括号都必须恰好使用 n 个","不能等到生成完整字符串后才判断合法性","回溯返回前要撤销刚加入的字符"],c=[{id:"backtracking",title:"合法前缀回溯",kind:"最优",idea:"记录已经使用的左右括号数量，只扩展仍满足合法前缀条件的分支。",steps:["左括号不足 n 个时可以继续添加","右括号少于左括号时才允许添加右括号","字符串长度达到 2n 时保存答案"],complexity:{time:"O(Cₙ · n)",space:"O(n)"},code:{java:`class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(int n, int open, int close, StringBuilder path, List<String> answer) {
        if (path.length() == 2 * n) {
            answer.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            build(n, open + 1, close, path, answer);
            path.setLength(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            build(n, open, close + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}
`,kotlin:`class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val answer = ArrayList<String>()
        build(n, 0, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(n: Int, open: Int, close: Int, path: StringBuilder, answer: MutableList<String>) {
        if (path.length == 2 * n) {
            answer.add(path.toString())
            return
        }
        if (open < n) {
            path.append('(')
            build(n, open + 1, close, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
        if (close < open) {
            path.append(')')
            build(n, open, close + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}
`,cpp:`class Solution {
    void build(int n, int open, int close, string& path, vector<string>& answer) {
        if ((int)path.size() == 2 * n) {
            answer.push_back(path);
            return;
        }
        if (open < n) {
            path.push_back('(');
            build(n, open + 1, close, path, answer);
            path.pop_back();
        }
        if (close < open) {
            path.push_back(')');
            build(n, open, close + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        string path;
        build(n, 0, 0, path, answer);
        return answer;
    }
};
`}}],g={id:22,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:a,paidOnly:!1,sourceUrl:s,title:i,studyTags:r,summary:p,insight:o,pitfalls:l,solutions:c};export{e as category,g as default,d as difficulty,h as id,o as insight,a as officialTags,u as paidOnly,l as pitfalls,n as slug,c as solutions,s as sourceUrl,r as studyTags,p as summary,i as title,t as titleEn};
