const c=46,n="permutations",e="Permutations",l="中等",t="搜索与回溯",s=["数组","回溯"],p=!1,i="https://leetcode.cn/problems/permutations/",m="全排列",a=["回溯","使用标记","决策树"],r="给定一个不含重复元素的整数数组，返回其中所有可能的排列。",u="排列的每个位置都可以从尚未使用的元素中选择，使用布尔数组即可维护当前路径的可选集合。",d=["同一个下标在一条路径中只能使用一次","保存答案时必须复制当前路径","回溯后要同时撤销路径和使用标记"],o=[{id:"used-array-backtracking",title:"使用标记回溯",kind:"最优",idea:"逐位置选择尚未进入路径的元素，路径长度等于数组长度时得到一个排列。",steps:["建立 used 数组","枚举所有未使用元素加入路径","递归返回后恢复 used 并删除路径末尾"],complexity:{time:"O(n · n!)",space:"O(n)"},code:{java:`class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (used[index]) continue;
            used[index] = true;
            path.add(nums[index]);
            build(nums, used, path, answer);
            path.remove(path.size() - 1);
            used[index] = false;
        }
    }
}
`,kotlin:`class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, BooleanArray(nums.size), ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, used: BooleanArray, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (path.size == nums.size) {
            answer.add(ArrayList(path))
            return
        }
        for (index in nums.indices) {
            if (used[index]) continue
            used[index] = true
            path.add(nums[index])
            build(nums, used, path, answer)
            path.removeAt(path.lastIndex)
            used[index] = false
        }
    }
}
`,cpp:`class Solution {
    void build(const vector<int>& nums, vector<bool>& used, vector<int>& path, vector<vector<int>>& answer) {
        if (path.size() == nums.size()) {
            answer.push_back(path);
            return;
        }
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (used[index]) continue;
            used[index] = true;
            path.push_back(nums[index]);
            build(nums, used, path, answer);
            path.pop_back();
            used[index] = false;
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        vector<bool> used(nums.size());
        build(nums, used, path, answer);
        return answer;
    }
};
`}}],h={id:46,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:s,paidOnly:!1,sourceUrl:i,title:"全排列",studyTags:a,summary:r,insight:u,pitfalls:d,solutions:o};export{t as category,h as default,l as difficulty,c as id,u as insight,s as officialTags,p as paidOnly,d as pitfalls,n as slug,o as solutions,i as sourceUrl,a as studyTags,r as summary,m as title,e as titleEn};
