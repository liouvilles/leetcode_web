const h=39,n="combination-sum",t="Combination Sum",l="中等",a="搜索与回溯",i=["数组","回溯"],m=!1,e="https://leetcode.cn/problems/combination-sum/",s="组合总和",r=["回溯","可重复选择","排序剪枝"],d="从互不相同的正整数候选值中选取若干个数，使总和等于目标值；每个候选值可以重复使用。",c="回溯时继续从当前下标选择即可允许重复，同时避免因选择顺序不同而产生重复组合。",o=["同一个候选值允许选多次","下一层从当前下标而不是下一个下标开始","排序后当前值超过剩余目标即可停止枚举"],p=[{id:"sorted-backtracking",title:"排序剪枝回溯",kind:"最优",idea:"维护剩余目标和起始下标，以非递减顺序构造组合。",steps:["候选数组排序","从 start 开始尝试不超过 remaining 的值","选择后仍传入当前下标，返回时撤销选择"],complexity:{time:"O(S)",space:"O(target / min(candidates))"},code:{java:`class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void search(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> answer) {
        if (remaining == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = start; index < candidates.length && candidates[index] <= remaining; index++) {
            path.add(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
`,kotlin:`class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val answer = ArrayList<List<Int>>()
        search(candidates, target, 0, ArrayList(), answer)
        return answer
    }

    private fun search(candidates: IntArray, remaining: Int, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (remaining == 0) {
            answer.add(ArrayList(path))
            return
        }
        for (index in start until candidates.size) {
            if (candidates[index] > remaining) break
            path.add(candidates[index])
            search(candidates, remaining - candidates[index], index, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}
`,cpp:`class Solution {
    void search(const vector<int>& candidates, int remaining, int start, vector<int>& path, vector<vector<int>>& answer) {
        if (remaining == 0) {
            answer.push_back(path);
            return;
        }
        for (int index = start; index < (int)candidates.size() && candidates[index] <= remaining; ++index) {
            path.push_back(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> answer;
        vector<int> path;
        search(candidates, target, 0, path, answer);
        return answer;
    }
};
`}}],g={id:39,slug:n,titleEn:t,difficulty:"中等",category:a,officialTags:i,paidOnly:!1,sourceUrl:e,title:s,studyTags:r,summary:d,insight:c,pitfalls:o,solutions:p};export{a as category,g as default,l as difficulty,h as id,c as insight,i as officialTags,m as paidOnly,o as pitfalls,n as slug,p as solutions,e as sourceUrl,r as studyTags,d as summary,s as title,t as titleEn};
