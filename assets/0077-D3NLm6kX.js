const k=77,t="combinations",n="Combinations",p="中等",a="搜索与回溯",i=["回溯"],u=!1,e="https://leetcode.cn/problems/combinations/",v="组合",s=["回溯","剪枝","组合枚举"],r="从 1 到 n 中选择 k 个不同数字，返回所有不考虑顺序的组合。",c="递增选择下一个数字天然消除排列重复；根据还需选择的数量限制枚举上界可以提前剪枝。",o=["组合内必须保持递增选择","加入答案时需要复制当前路径","候选上界要为剩余位置留足数字"],l=[{id:"backtracking-pruning",title:"递增回溯剪枝",kind:"最优",idea:"路径只向更大数字扩展，并用剩余数量计算本层最大起点。",steps:["路径长度达到 k 时复制到答案","枚举 value 到 n-(k-size)+1","选择、递归、撤销选择"],complexity:{time:"O(C(n,k)·k)",space:"O(k) excluding output"},code:{java:`class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>(); backtrack(1, n, k, new ArrayList<>(), answer); return answer;
    }
    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == k) { answer.add(new ArrayList<>(path)); return; }
        int limit = n - (k - path.size()) + 1;
        for (int value = start; value <= limit; value++) { path.add(value); backtrack(value + 1, n, k, path, answer); path.remove(path.size() - 1); }
    }
}
`,kotlin:`class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>()
        fun backtrack(start: Int) { if (path.size == k) { answer.add(path.toList()); return }; val limit = n - (k - path.size) + 1; for (value in start..limit) { path.add(value); backtrack(value + 1); path.removeAt(path.lastIndex) } }
        backtrack(1); return answer
    }
}
`,cpp:`class Solution {
    void backtrack(int start, int n, int k, vector<int>& path, vector<vector<int>>& answer) {
        if ((int)path.size() == k) { answer.push_back(path); return; }
        int limit = n - (k - path.size()) + 1;
        for (int value = start; value <= limit; ++value) { path.push_back(value); backtrack(value + 1, n, k, path, answer); path.pop_back(); }
    }
public:
    vector<vector<int>> combine(int n, int k) { vector<vector<int>> answer; vector<int> path; backtrack(1, n, k, path, answer); return answer; }
};
`}}],h={id:77,slug:t,titleEn:n,difficulty:"中等",category:a,officialTags:i,paidOnly:!1,sourceUrl:e,title:"组合",studyTags:s,summary:r,insight:c,pitfalls:o,solutions:l};export{a as category,h as default,p as difficulty,k as id,c as insight,i as officialTags,u as paidOnly,o as pitfalls,t as slug,l as solutions,e as sourceUrl,s as studyTags,r as summary,v as title,n as titleEn};
