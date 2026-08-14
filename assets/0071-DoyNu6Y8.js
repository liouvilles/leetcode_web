const l=71,t="simplify-path",s="Simplify Path",f="中等",y="字符串",n=["字符串","栈"],u=!1,a="https://leetcode.cn/problems/simplify-path/",i="简化路径",r=["栈","路径解析","字符串"],e="把 Unix 风格绝对路径规范化，消除重复斜杠、当前目录和可回退的父目录片段。",c="按斜杠分段，用栈保存有效目录名；普通名称入栈，两个点弹栈，一个点和空段忽略。",p=["根目录不能继续向上回退","多个连续斜杠等同一个","三个及以上点是普通目录名"],o=[{id:"directory-stack",title:"目录栈归一化",kind:"最优",idea:"逐段解释路径语义，栈中始终保存规范路径的目录序列。",steps:["按 / 拆分片段","忽略空串和 .，对 .. 弹栈","普通片段入栈，最后用 / 连接"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) { if (part.isEmpty() || part.equals(".")) continue; if (part.equals("..")) { if (!stack.isEmpty()) stack.removeLast(); } else stack.addLast(part); }
        return "/" + String.join("/", stack);
    }
}
`,kotlin:`class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (part in path.split('/')) { if (part.isEmpty() || part == ".") continue; if (part == "..") { if (stack.isNotEmpty()) stack.removeLast() } else stack.addLast(part) }
        return "/" + stack.joinToString("/")
    }
}
`,cpp:`class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack; string part; stringstream stream(path);
        while (getline(stream, part, '/')) { if (part.empty() || part == ".") continue; if (part == "..") { if (!stack.empty()) stack.pop_back(); } else stack.push_back(part); }
        string answer; for (const string& directory : stack) answer += "/" + directory; return answer.empty() ? "/" : answer;
    }
};
`}}],g={id:71,slug:t,titleEn:s,difficulty:"中等",category:"字符串",officialTags:n,paidOnly:!1,sourceUrl:a,title:i,studyTags:r,summary:e,insight:c,pitfalls:p,solutions:o};export{y as category,g as default,f as difficulty,l as id,c as insight,n as officialTags,u as paidOnly,p as pitfalls,t as slug,o as solutions,a as sourceUrl,r as studyTags,e as summary,i as title,s as titleEn};
