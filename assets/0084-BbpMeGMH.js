const o=84,t="largest-rectangle-in-histogram",e="Largest Rectangle in Histogram",d="困难",n="数据结构与设计",s=["数组","栈","单调栈","Range Minimum/Maximum Query"],k=!1,i="https://leetcode.cn/problems/largest-rectangle-in-histogram/",a="柱状图中最大的矩形",c=["单调栈","左右边界","哨兵"],h="柱状图每根柱宽度为一，求由连续柱子组成的最大轴对齐矩形面积。",g="当遇到更矮柱子时，栈顶高度的右边界确定；弹栈后新栈顶就是它左侧第一个更矮位置。",l=["面积宽度是 right-left-1","末尾需要哨兵触发剩余柱子出栈","栈中保存下标而不是高度"],r=[{id:"monotonic-stack",title:"递增单调栈",kind:"最优",idea:"维护高度非递减的下标栈，并在高度下降时结算被弹出柱子的最大宽度。",steps:["压入左侧哨兵下标 -1","当前高度更小时反复弹栈计算面积","扫描到 n 时使用高度零的右哨兵"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int best = 0;
        for (int index = 0; index <= heights.length; index++) {
            int height = index == heights.length ? 0 : heights[index];
            while (stack.peek() != -1 && heights[stack.peek()] > height) {
                int rectangleHeight = heights[stack.pop()];
                best = Math.max(best, rectangleHeight * (index - stack.peek() - 1));
            }
            stack.push(index);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack: ArrayDeque<Int> = ArrayDeque()
        stack.addLast(-1)
        var best = 0
        for (index in 0..heights.size) {
            val height = if (index == heights.size) 0 else heights[index]
            while (stack.last() != -1 && heights[stack.last()] > height) { val rectangleHeight = heights[stack.removeLast()]; best = maxOf(best, rectangleHeight * (index - stack.last() - 1)) }
            stack.addLast(index)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> stack = {-1};
        int best = 0;
        for (int index = 0; index <= (int)heights.size(); ++index) {
            int height = index == (int)heights.size() ? 0 : heights[index];
            while (stack.back() != -1 && heights[stack.back()] > height) { int rectangleHeight = heights[stack.back()]; stack.pop_back(); best = max(best, rectangleHeight * (index - stack.back() - 1)); }
            stack.push_back(index);
        }
        return best;
    }
};
`}}],u={id:84,slug:t,titleEn:e,difficulty:"困难",category:n,officialTags:s,paidOnly:!1,sourceUrl:i,title:a,studyTags:c,summary:h,insight:g,pitfalls:l,solutions:r};export{n as category,u as default,d as difficulty,o as id,g as insight,s as officialTags,k as paidOnly,l as pitfalls,t as slug,r as solutions,i as sourceUrl,c as studyTags,h as summary,a as title,e as titleEn};
