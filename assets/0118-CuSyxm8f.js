const w=118,n="pascals-triangle",o="Pascal's Triangle",m="简单",t="动态规划",r=["数组","动态规划"],d=!1,s="https://leetcode.cn/problems/pascals-triangle/",e="杨辉三角",c=["动态规划","二维列表","递推"],u="生成杨辉三角的前 numRows 行，每行首尾为一，其余元素等于上一行相邻两数之和。",l="第 row 行有 row+1 个元素，边界直接填一，内部位置从上一行的 column-1 与 column 转移。",i=["行下标从零开始时长度为 row+1","首尾元素没有两个父元素","答案逐行依赖上一行"],a=[{id:"row-by-row-dp",title:"逐行递推",kind:"最优",idea:"按定义从上一行构造下一行，并立即加入结果。",steps:["为当前行创建 row+1 个位置","边界填一","内部填 previous[column-1]+previous[column]"],complexity:{time:"O(numRows²)",space:"O(numRows²)"},code:{java:`class Solution {
    public List<List<Integer>> generate(int numRows) { List<List<Integer>> answer = new ArrayList<>(); for (int row = 0; row < numRows; row++) { List<Integer> current = new ArrayList<>(); for (int column = 0; column <= row; column++) current.add(column == 0 || column == row ? 1 : answer.get(row - 1).get(column - 1) + answer.get(row - 1).get(column)); answer.add(current); } return answer; }
}
`,kotlin:`class Solution {
    fun generate(numRows: Int): List<List<Int>> { val answer = mutableListOf<List<Int>>(); for (row in 0 until numRows) { val current = MutableList(row + 1) { 1 }; for (column in 1 until row) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.add(current) }; return answer }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> generate(int numRows) { vector<vector<int>> answer; for (int row = 0; row < numRows; ++row) { vector<int> current(row + 1, 1); for (int column = 1; column < row; ++column) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.push_back(current); } return answer; }
};
`}}],p={id:118,slug:n,titleEn:o,difficulty:"简单",category:t,officialTags:r,paidOnly:!1,sourceUrl:s,title:e,studyTags:c,summary:u,insight:l,pitfalls:i,solutions:a};export{t as category,p as default,m as difficulty,w as id,l as insight,r as officialTags,d as paidOnly,i as pitfalls,n as slug,a as solutions,s as sourceUrl,c as studyTags,u as summary,e as title,o as titleEn};
