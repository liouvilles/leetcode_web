const p=90,t="subsets-ii",n="Subsets II",l="中等",s="搜索与回溯",e=["数组","回溯","位运算"],m=!1,i="https://leetcode.cn/problems/subsets-ii/",a="子集 II",r=["回溯","排序去重","子集枚举"],c="返回可能含重复元素的整数数组的所有不同子集，结果中不能出现重复子集。",u="先排序让相同值相邻；同一递归层中只选择相同值的第一次出现，仍允许在更深层再次选择它。",o=["去重只发生在同一递归层","空集也必须加入答案","加入答案时需要复制路径"],d=[{id:"sorted-backtracking",title:"排序后同层去重",kind:"最优",idea:"每个递归节点先记录当前路径，再枚举后续元素并跳过同层重复项。",steps:["数组排序","每次递归复制路径到答案","从 start 枚举，若 index>start 且与前项相同则跳过"],complexity:{time:"O(n·2^n)",space:"O(n) excluding output"},code:{java:`class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) { Arrays.sort(nums); List<List<Integer>> answer = new ArrayList<>(); backtrack(0, nums, new ArrayList<>(), answer); return answer; }
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> answer) { answer.add(new ArrayList<>(path)); for (int index = start; index < nums.length; index++) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1, nums, path, answer); path.remove(path.size() - 1); } }
}
`,kotlin:`class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> { nums.sort(); val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>(); fun backtrack(start: Int) { answer.add(path.toList()); for (index in start until nums.size) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1); path.removeAt(path.lastIndex) } }; backtrack(0); return answer }
}
`,cpp:`class Solution {
    void backtrack(int start, const vector<int>& nums, vector<int>& path, vector<vector<int>>& answer) { answer.push_back(path); for (int index = start; index < (int)nums.size(); ++index) { if (index > start && nums[index] == nums[index - 1]) continue; path.push_back(nums[index]); backtrack(index + 1, nums, path, answer); path.pop_back(); } }
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) { sort(nums.begin(), nums.end()); vector<vector<int>> answer; vector<int> path; backtrack(0, nums, path, answer); return answer; }
};
`}}],x={id:90,slug:t,titleEn:n,difficulty:"中等",category:s,officialTags:e,paidOnly:!1,sourceUrl:i,title:a,studyTags:r,summary:c,insight:u,pitfalls:o,solutions:d};export{s as category,x as default,l as difficulty,p as id,u as insight,e as officialTags,m as paidOnly,o as pitfalls,t as slug,d as solutions,i as sourceUrl,r as studyTags,c as summary,a as title,n as titleEn};
