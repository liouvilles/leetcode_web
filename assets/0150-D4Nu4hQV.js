const f=150,t="evaluate-reverse-polish-notation",e="Evaluate Reverse Polish Notation",p="中等",n="数据结构与设计",s=["数组","数学","栈"],u=!1,a="https://leetcode.cn/problems/evaluate-reverse-polish-notation/",o="逆波兰表达式求值",i=["栈","后缀表达式","操作数顺序"],l="计算由整数和加减乘除运算符组成的有效逆波兰表达式，整数除法向零截断。",c="数字入栈；遇到运算符时弹出右操作数和左操作数，计算结果再入栈。",k=["减法和除法必须保留左右操作数顺序","负整数 token 不是减号运算符","Java、Kotlin、C++ 整数除法均向零截断"],r=[{id:"operand-stack",title:"操作数栈",kind:"最优",idea:"扫描后缀 token 并即时归约最近两个操作数。",steps:["数字解析后入栈","运算符先弹 right 再弹 left","计算 left op right 并压回"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) { if (token.length() == 1 && "+-*/".contains(token)) { int right = stack.pop(), left = stack.pop(); if (token.equals("+")) stack.push(left + right); else if (token.equals("-")) stack.push(left - right); else if (token.equals("*")) stack.push(left * right); else stack.push(left / right); } else stack.push(Integer.parseInt(token)); }
        return stack.pop();
    }
}
`,kotlin:`class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) { if (token.length == 1 && token[0] in "+-*/") { val right = stack.removeLast(); val left = stack.removeLast(); stack.addLast(when (token) { "+" -> left + right; "-" -> left - right; "*" -> left * right; else -> left / right }) } else stack.addLast(token.toInt()) }
        return stack.last()
    }
}
`,cpp:`class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        vector<int> stack;
        for (const string& token : tokens) { if (token.size() == 1 && string("+-*/").find(token[0]) != string::npos) { int right = stack.back(); stack.pop_back(); int left = stack.back(); stack.pop_back(); if (token == "+") stack.push_back(left + right); else if (token == "-") stack.push_back(left - right); else if (token == "*") stack.push_back(left * right); else stack.push_back(left / right); } else stack.push_back(stoi(token)); }
        return stack.back();
    }
};
`}}],h={id:150,slug:t,titleEn:e,difficulty:"中等",category:n,officialTags:s,paidOnly:!1,sourceUrl:a,title:o,studyTags:i,summary:l,insight:c,pitfalls:k,solutions:r};export{n as category,h as default,p as difficulty,f as id,c as insight,s as officialTags,u as paidOnly,k as pitfalls,t as slug,r as solutions,a as sourceUrl,i as studyTags,l as summary,o as title,e as titleEn};
