const o=155,t="min-stack",n="Min Stack",k="中等",i="数据结构与设计",a=["栈","设计"],m=!1,s="https://leetcode.cn/problems/min-stack/",r="最小栈",c=["设计题","辅助栈","同步最小值"],e="设计支持压栈、出栈、读取栈顶和常数时间获取当前最小元素的栈。",u="每个入栈位置同时保存截至该位置的最小值，出栈时两个状态自然同步回退。",l=["重复最小值需要分别记录","getMin 不能线性扫描","题目保证只在非空栈执行读取和弹出"],p=[{id:"paired-values",title:"值与前缀最小值成对入栈",kind:"最优",idea:"每个栈元素保存原值和加入它之后的最小值。",steps:["push 时比较当前值与旧最小值","pop 删除一整对状态","top 和 getMin 分别读取栈顶的两个字段"],complexity:{time:"O(1)",space:"O(n)"},code:{java:`class MinStack {
    private final Deque<int[]> stack = new ArrayDeque<>();
    public MinStack() {}
    public void push(int value) { int minimum = stack.isEmpty() ? value : Math.min(value, stack.peek()[1]); stack.push(new int[] {value, minimum}); }
    public void pop() { stack.pop(); }
    public int top() { return stack.peek()[0]; }
    public int getMin() { return stack.peek()[1]; }
}
`,kotlin:`class MinStack {
    private val stack = ArrayDeque<IntArray>()
    fun push(value: Int) { val minimum = if (stack.isEmpty()) value else minOf(value, stack.last()[1]); stack.addLast(intArrayOf(value, minimum)) }
    fun pop() { stack.removeLast() }
    fun top(): Int = stack.last()[0]
    fun getMin(): Int = stack.last()[1]
}
`,cpp:`class MinStack {
    vector<pair<int, int>> stack;
public:
    MinStack() {}
    void push(int value) { int minimum = stack.empty() ? value : min(value, stack.back().second); stack.push_back({value, minimum}); }
    void pop() { stack.pop_back(); }
    int top() { return stack.back().first; }
    int getMin() { return stack.back().second; }
};
`}}],v={id:155,slug:t,titleEn:n,difficulty:"中等",category:i,officialTags:a,paidOnly:!1,sourceUrl:s,title:"最小栈",studyTags:c,summary:e,insight:u,pitfalls:l,solutions:p};export{i as category,v as default,k as difficulty,o as id,u as insight,a as officialTags,m as paidOnly,l as pitfalls,t as slug,p as solutions,s as sourceUrl,c as studyTags,e as summary,r as title,n as titleEn};
