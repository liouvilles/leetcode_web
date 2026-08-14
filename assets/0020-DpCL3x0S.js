const p=20,n="valid-parentheses",e="Valid Parentheses",u="简单",d="字符串",s=["字符串","栈","Bracket Sequences"],h=!1,t="https://leetcode.cn/problems/valid-parentheses/",i="有效的括号",a=["配对消除","后进先出","边界检查"],l="判断只含三类括号的字符串是否满足类型匹配且闭合顺序正确。",c="右括号只能和最近一个尚未匹配的左括号配对，这正是栈的后进先出语义。",r=["右括号出现时栈可能为空","遍历结束后栈也必须为空","字符数量为奇数时一定无效"],o=[{id:"repeated-removal",title:"反复消除相邻括号",kind:"基础",idea:"任何合法括号串都能通过不断删除相邻的 ()、[]、{} 最终变为空串。",steps:["循环替换三种相邻括号对","某一轮长度不变时停止","检查剩余字符串是否为空"],complexity:{time:"O(n²)",space:"O(n)"},code:{java:`class Solution {
    public boolean isValid(String s) {
        int previousLength;
        do {
            previousLength = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (s.length() != previousLength);
        return s.isEmpty();
    }
}
`,kotlin:`class Solution {
    fun isValid(input: String): Boolean {
        var s = input
        do {
            val previousLength = s.length
            s = s.replace("()", "").replace("[]", "").replace("{}", "")
        } while (s.length != previousLength)
        return s.isEmpty()
    }
}
`,cpp:`class Solution {
public:
    bool isValid(string s) {
        size_t previous;
        do {
            previous = s.size();
            eraseAll(s, "()"); eraseAll(s, "[]"); eraseAll(s, "{}");
        } while (s.size() != previous);
        return s.empty();
    }

private:
    void eraseAll(string& s, const string& pair) {
        size_t pos;
        while ((pos = s.find(pair)) != string::npos) s.erase(pos, 2);
    }
};
`}},{id:"stack",title:"栈匹配",kind:"最优",idea:"遇到左括号时压入期待的右括号；遇到右括号时必须与栈顶一致。",steps:["奇数长度提前失败","左括号压入对应的右括号","右括号弹栈匹配，最终要求栈为空"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
`,kotlin:`class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        val stack = java.util.ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(' -> stack.push(')')
                '[' -> stack.push(']')
                '{' -> stack.push('}')
                else -> if (stack.isEmpty() || stack.pop() != c) return false
            }
        }
        return stack.isEmpty()
    }
}
`,cpp:`class Solution {
public:
    bool isValid(string s) {
        if (s.size() % 2 == 1) return false;
        stack<char> expected;
        for (char c : s) {
            if (c == '(') expected.push(')');
            else if (c == '[') expected.push(']');
            else if (c == '{') expected.push('}');
            else {
                if (expected.empty() || expected.top() != c) return false;
                expected.pop();
            }
        }
        return expected.empty();
    }
};
`}}],f={id:20,slug:n,titleEn:e,difficulty:"简单",category:"字符串",officialTags:s,paidOnly:!1,sourceUrl:t,title:i,studyTags:a,summary:l,insight:c,pitfalls:r,solutions:o};export{d as category,f as default,u as difficulty,p as id,c as insight,s as officialTags,h as paidOnly,r as pitfalls,n as slug,o as solutions,t as sourceUrl,a as studyTags,l as summary,i as title,e as titleEn};
