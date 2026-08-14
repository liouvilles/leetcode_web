const l=739,e="daily-temperatures",t="Daily Temperatures",d="中等",s="数据结构与设计",a=["数组","栈","单调栈"],y=!1,r="https://leetcode.cn/problems/daily-temperatures/",n="每日温度",i=["单调栈","下一个更大元素","下标差"],c="对每天的温度，计算还需等待多少天才会出现更高温度；若之后没有更高温度则为零。",o="栈保存尚未找到更高温度的日期，并保持温度非递增；新温度更高时可连续解决栈顶日期。",u=["需要严格更高，相等温度不能出栈","栈中保存下标用于计算天数","未出栈位置答案保持初始零"],p=[{id:"monotonic-stack",title:"递减温度栈",kind:"最优",idea:"扫描新温度时弹出所有更低日期，并填写下标差。",steps:["栈保存未解决日期","当前温度更高时反复弹栈","answer[old]=current-old 后压入当前下标"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length]; Deque<Integer> stack = new ArrayDeque<>();
        for (int day = 0; day < temperatures.length; day++) { while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) { int previous = stack.pop(); answer[previous] = day - previous; } stack.push(day); }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size); val stack: ArrayDeque<Int> = ArrayDeque()
        for (day in temperatures.indices) { while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[day]) { val previous = stack.removeLast(); answer[previous] = day - previous }; stack.addLast(day) }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> answer(temperatures.size()), stack;
        for (int day = 0; day < (int)temperatures.size(); ++day) { while (!stack.empty() && temperatures[stack.back()] < temperatures[day]) { int previous = stack.back(); stack.pop_back(); answer[previous] = day - previous; } stack.push_back(day); }
        return answer;
    }
};
`}}],m={id:739,slug:e,titleEn:t,difficulty:"中等",category:s,officialTags:a,paidOnly:!1,sourceUrl:r,title:n,studyTags:i,summary:c,insight:o,pitfalls:u,solutions:p};export{s as category,m as default,d as difficulty,l as id,o as insight,a as officialTags,y as paidOnly,u as pitfalls,e as slug,p as solutions,r as sourceUrl,i as studyTags,c as summary,n as title,t as titleEn};
