const d=78,n="subsets",t="Subsets",l="中等",s="搜索与回溯",i=["数组","回溯","位运算"],p=!1,e="https://leetcode.cn/problems/subsets/",m="子集",a=["回溯","组合枚举","空集"],r="给定一个不含重复元素的整数数组，返回它的所有子集，包括空集和数组本身。",u="当前路径本身就是一个合法子集；随后只从更大的下标继续选择，便能保证每个子集只出现一次。",o=["空集必须包含在答案中","递归下一层从 index + 1 开始","保存当前路径时需要创建副本"],c=[{id:"backtracking",title:"递增下标回溯",kind:"最优",idea:"每到一个递归节点先保存当前路径，再依次选择后续元素继续扩展。",steps:["保存当前路径作为一个子集","从 start 开始枚举下一元素","递归后删除最后加入的元素"],complexity:{time:"O(n · 2ⁿ)",space:"O(n)"},code:{java:`class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, int start, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int index = start; index < nums.length; index++) {
            path.add(nums[index]);
            build(nums, index + 1, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
`,kotlin:`class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, 0, ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        answer.add(ArrayList(path))
        for (index in start until nums.size) {
            path.add(nums[index])
            build(nums, index + 1, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}
`,cpp:`class Solution {
    void build(const vector<int>& nums, int start, vector<int>& path, vector<vector<int>>& answer) {
        answer.push_back(path);
        for (int index = start; index < (int)nums.size(); ++index) {
            path.push_back(nums[index]);
            build(nums, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        build(nums, 0, path, answer);
        return answer;
    }
};
`}}],b={id:78,slug:n,titleEn:t,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:e,title:"子集",studyTags:a,summary:r,insight:u,pitfalls:o,solutions:c};export{s as category,b as default,l as difficulty,d as id,u as insight,i as officialTags,p as paidOnly,o as pitfalls,n as slug,c as solutions,e as sourceUrl,a as studyTags,r as summary,m as title,t as titleEn};
