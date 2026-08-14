const c=57,n="insert-interval",e="Insert Interval",o="中等",t="数组与矩阵",i=["数组"],x=!1,a="https://leetcode.cn/problems/insert-interval/",r="插入区间",s=["区间合并","线性扫描","分类讨论"],l="把一个新区间插入按起点有序且互不重叠的区间列表，并合并所有重叠部分。",v="区间只分为新区间左侧、与新区间重叠、以及新区间右侧三段，按顺序一次扫描即可。",d=["端点相接也应视为重叠","新区间可能覆盖多个原区间","输入为空时只返回新区间"],w=[{id:"three-phase-scan",title:"三阶段线性合并",kind:"最优",idea:"先收集完全位于左侧的区间，再扩张新区间，最后追加右侧区间。",steps:["追加 end < newStart 的区间","对 start <= newEnd 的区间更新合并边界","加入合并区间和剩余区间"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>(); int index = 0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) answer.add(intervals[index++]);
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) { newInterval[0] = Math.min(newInterval[0], intervals[index][0]); newInterval[1] = Math.max(newInterval[1], intervals[index++][1]); }
        answer.add(newInterval); while (index < intervals.length) answer.add(intervals[index++]);
        return answer.toArray(new int[answer.size()][]);
    }
}
`,kotlin:`class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val answer = mutableListOf<IntArray>(); var index = 0
        while (index < intervals.size && intervals[index][1] < newInterval[0]) answer.add(intervals[index++])
        while (index < intervals.size && intervals[index][0] <= newInterval[1]) { newInterval[0] = minOf(newInterval[0], intervals[index][0]); newInterval[1] = maxOf(newInterval[1], intervals[index++][1]) }
        answer.add(newInterval); while (index < intervals.size) answer.add(intervals[index++])
        return answer.toTypedArray()
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> answer; int index = 0;
        while (index < (int)intervals.size() && intervals[index][1] < newInterval[0]) answer.push_back(intervals[index++]);
        while (index < (int)intervals.size() && intervals[index][0] <= newInterval[1]) { newInterval[0] = min(newInterval[0], intervals[index][0]); newInterval[1] = max(newInterval[1], intervals[index++][1]); }
        answer.push_back(newInterval); while (index < (int)intervals.size()) answer.push_back(intervals[index++]); return answer;
    }
};
`}}],I={id:57,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:a,title:r,studyTags:s,summary:l,insight:v,pitfalls:d,solutions:w};export{t as category,I as default,o as difficulty,c as id,v as insight,i as officialTags,x as paidOnly,d as pitfalls,n as slug,w as solutions,a as sourceUrl,s as studyTags,l as summary,r as title,e as titleEn};
