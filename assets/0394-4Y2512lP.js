const u=394,e="decode-string",t="Decode String",l="中等",d="字符串",r=["字符串","栈","递归"],g=!1,n="https://leetcode.cn/problems/decode-string/",s="字符串解码",i=["栈","嵌套结构","多位数字"],o="把 k[片段] 形式的编码字符串展开，编码可以嵌套且重复次数可能有多位。",c="遇到左括号时保存外层已构造字符串和重复次数，右括号时完成当前层并拼回外层。",a=["重复次数可能超过一位","嵌套层需要成对保存次数和字符串","普通字母直接追加到当前层"],p=[{id:"two-stacks",title:"次数栈 + 字符串栈",kind:"最优",idea:"扫描字符并在括号边界切换当前构造层。",steps:["数字连续累积为 repeat","左括号时压入外层状态并清空当前层","右括号时弹出状态并重复拼接当前层"],complexity:{time:"O(output length)",space:"O(n)"},code:{java:`class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>(); Deque<StringBuilder> prefixes = new ArrayDeque<>(); StringBuilder current = new StringBuilder(); int repeat = 0;
        for (char symbol : s.toCharArray()) { if (Character.isDigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push(repeat); prefixes.push(current); current = new StringBuilder(); repeat = 0; } else if (symbol == ']') { int times = counts.pop(); StringBuilder expanded = prefixes.pop(); while (times-- > 0) expanded.append(current); current = expanded; } else current.append(symbol); }
        return current.toString();
    }
}
`,kotlin:`class Solution {
    fun decodeString(s: String): String {
        val counts = ArrayDeque<Int>(); val prefixes = ArrayDeque<StringBuilder>(); var current = StringBuilder(); var repeat = 0
        for (symbol in s) { when { symbol.isDigit() -> repeat = repeat * 10 + symbol.digitToInt(); symbol == '[' -> { counts.addLast(repeat); prefixes.addLast(current); current = StringBuilder(); repeat = 0 }; symbol == ']' -> { var times = counts.removeLast(); val expanded = prefixes.removeLast(); while (times-- > 0) expanded.append(current); current = expanded }; else -> current.append(symbol) } }
        return current.toString()
    }
}
`,cpp:`class Solution {
public:
    string decodeString(string s) {
        vector<int> counts; vector<string> prefixes; string current; int repeat = 0;
        for (char symbol : s) { if (isdigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push_back(repeat); prefixes.push_back(current); current.clear(); repeat = 0; } else if (symbol == ']') { int times = counts.back(); counts.pop_back(); string expanded = prefixes.back(); prefixes.pop_back(); while (times-- > 0) expanded += current; current = move(expanded); } else current.push_back(symbol); }
        return current;
    }
};
`}}],m={id:394,slug:e,titleEn:t,difficulty:"中等",category:"字符串",officialTags:r,paidOnly:!1,sourceUrl:n,title:s,studyTags:i,summary:o,insight:c,pitfalls:a,solutions:p};export{d as category,m as default,l as difficulty,u as id,c as insight,r as officialTags,g as paidOnly,a as pitfalls,e as slug,p as solutions,n as sourceUrl,i as studyTags,o as summary,s as title,t as titleEn};
