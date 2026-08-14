const g=17,t="letter-combinations-of-a-phone-number",n="Letter Combinations of a Phone Number",p="中等",c="字符串",i=["哈希表","字符串","回溯"],u=!1,e="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/",s="电话号码的字母组合",r=["回溯","字符映射","笛卡尔积"],a="根据数字键 2 到 9 对应的字母，返回给定数字串可以表示的所有字母组合。",d="每个数字提供一组选项，按位置深度优先选择一个字母即可枚举这些集合的笛卡尔积。",o=["空输入应返回空列表而不是包含空字符串","每深入一层只处理一个数字","回溯后要删除路径末尾字符"],l=[{id:"backtracking",title:"逐位回溯",kind:"最优",idea:"用固定数组保存按键映射，递归构造与数字串等长的字母路径。",steps:["空输入直接返回空集合","读取当前位置数字对应的字母串","依次选择字母并递归到下一位"],complexity:{time:"O(4ⁿ · n)",space:"O(n)"},code:{java:`class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        build(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(String digits, int index, StringBuilder path, List<String> answer) {
        if (index == digits.length()) { answer.add(path.toString()); return; }
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (int offset = 0; offset < letters.length(); offset++) {
            path.append(letters.charAt(offset));
            build(digits, index + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}
`,kotlin:`class Solution {
    private val letters = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val answer = ArrayList<String>()
        build(digits, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(digits: String, index: Int, path: StringBuilder, answer: MutableList<String>) {
        if (index == digits.length) { answer.add(path.toString()); return }
        for (letter in letters[digits[index].digitToInt()]) {
            path.append(letter)
            build(digits, index + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}
`,cpp:`class Solution {
    const vector<string> letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    void build(const string& digits, int index, string& path, vector<string>& answer) {
        if (index == (int)digits.size()) { answer.push_back(path); return; }
        for (char letter : letters[digits[index] - '0']) {
            path.push_back(letter);
            build(digits, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};
        vector<string> answer;
        string path;
        build(digits, 0, path, answer);
        return answer;
    }
};
`}}],h={id:17,slug:t,titleEn:n,difficulty:"中等",category:"字符串",officialTags:i,paidOnly:!1,sourceUrl:e,title:s,studyTags:r,summary:a,insight:d,pitfalls:o,solutions:l};export{c as category,h as default,p as difficulty,g as id,d as insight,i as officialTags,u as paidOnly,o as pitfalls,t as slug,l as solutions,e as sourceUrl,r as studyTags,a as summary,s as title,n as titleEn};
