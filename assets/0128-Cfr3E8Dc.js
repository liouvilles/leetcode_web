const v=128,n="longest-consecutive-sequence",e="Longest Consecutive Sequence",g="中等",r="图论",t=["数组","哈希表","并查集"],h=!1,s="https://leetcode.cn/problems/longest-consecutive-sequence/",l="最长连续序列",u=["哈希集合","序列起点","避免重复扫描"],i="在未排序整数数组中，求数值连续递增一的最长序列长度，要求整体线性时间。",a="只有当 x-1 不在集合中时，x 才是某条连续序列的起点；从起点向后扫描不会重复覆盖其他序列。",o=["连续序列按数值而不是原数组位置定义","重复元素不应增加长度","从每个元素都双向扩展会退化为平方时间"],c=[{id:"hash-sequence-start",title:"哈希集合识别起点",kind:"最优",idea:"把所有值放入集合，只从没有前驱的值开始统计连续长度。",steps:["建立去重哈希集合","跳过存在 value - 1 的非起点","从起点递增查找并更新最长长度"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int value : nums) values.add(value);
        int best = 0;
        for (int value : values) {
            if (values.contains(value - 1)) continue;
            int length = 1;
            while (values.contains(value + length)) length++;
            best = Math.max(best, length);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val values = nums.toHashSet()
        var best = 0
        for (value in values) {
            if (value - 1 in values) continue
            var length = 1
            while (value + length in values) length++
            best = maxOf(best, length)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> values(nums.begin(), nums.end());
        int best = 0;
        for (int value : values) {
            if (values.count(value - 1)) continue;
            int length = 1;
            while (values.count(value + length)) ++length;
            best = max(best, length);
        }
        return best;
    }
};
`}}],d={id:128,slug:n,titleEn:e,difficulty:"中等",category:"图论",officialTags:t,paidOnly:!1,sourceUrl:s,title:l,studyTags:u,summary:i,insight:a,pitfalls:o,solutions:c};export{r as category,d as default,g as difficulty,v as id,a as insight,t as officialTags,h as paidOnly,o as pitfalls,n as slug,c as solutions,s as sourceUrl,u as studyTags,i as summary,l as title,e as titleEn};
