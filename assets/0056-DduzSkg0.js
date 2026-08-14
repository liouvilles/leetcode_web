const m=56,e="merge-intervals",n="Merge Intervals",g="中等",t="数组与矩阵",r=["数组","排序","快速排序"],v=!1,a="https://leetcode.cn/problems/merge-intervals/",i="合并区间",s=["区间排序","扫描合并","边界维护"],l="合并一组可能互相重叠的闭区间，返回覆盖范围相同且互不重叠的区间集合。",o="按起点排序后，新区间只可能与当前合并结果的最后一个区间重叠。",c=["端点相等的闭区间也应合并","重叠时右端点要取两者最大值","输入顺序不能直接用于线性合并"],d=[{id:"sort-and-scan",title:"排序后线性扫描",kind:"最优",idea:"先按左端点排序，再维护当前尚未结束的合并区间。",steps:["按区间起点升序排序","若新区间起点超过当前右端点则开始新区间","否则扩大当前区间的右端点"],complexity:{time:"O(n log n)",space:"O(n)"},code:{java:`class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {interval[0], interval[1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
`,kotlin:`class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy<IntArray> { it[0] })
        val merged = ArrayList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || interval[0] > merged.last()[1]) {
                merged.add(intArrayOf(interval[0], interval[1]))
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> merged;
        for (const auto& interval : intervals) {
            if (merged.empty() || interval[0] > merged.back()[1]) {
                merged.push_back(interval);
            } else {
                merged.back()[1] = max(merged.back()[1], interval[1]);
            }
        }
        return merged;
    }
};
`}}],y={id:56,slug:e,titleEn:n,difficulty:"中等",category:t,officialTags:r,paidOnly:!1,sourceUrl:a,title:i,studyTags:s,summary:l,insight:o,pitfalls:c,solutions:d};export{t as category,y as default,g as difficulty,m as id,o as insight,r as officialTags,v as paidOnly,c as pitfalls,e as slug,d as solutions,a as sourceUrl,s as studyTags,l as summary,i as title,n as titleEn};
