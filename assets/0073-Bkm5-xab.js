const c=73,o="set-matrix-zeroes",r="Set Matrix Zeroes",u="中等",i="数组与矩阵",t=["数组","哈希表","矩阵"],x=!1,n="https://leetcode.cn/problems/set-matrix-zeroes/",m="矩阵置零",l=["原地标记","首行首列","矩阵"],a="若矩阵中某元素为零，就把它所在的整行和整列都设为零，要求原地完成。",e="用矩阵第一行和第一列充当标记数组，再额外记录它们自身是否原本包含零。",s=["首行首列需要独立布尔标记","写标记时不能提前清零整行整列","最后处理首行首列"],f=[{id:"first-row-column-markers",title:"首行首列复用标记",kind:"最优",idea:"扫描内部零并在对应首行首列位置做标记，第二遍据此清零。",steps:["记录首行和首列是否含零","扫描内部元素并写行列标记","清零内部后按布尔标记处理首行首列"],complexity:{time:"O(mn)",space:"O(1)"},code:{java:`class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColumnZero = false;
        for (int column = 0; column < matrix[0].length; column++) if (matrix[0][column] == 0) firstRowZero = true;
        for (int row = 0; row < matrix.length; row++) if (matrix[row][0] == 0) firstColumnZero = true;
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) Arrays.fill(matrix[0], 0);
        if (firstColumnZero) for (int[] row : matrix) row[0] = 0;
    }
}
`,kotlin:`class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var firstRowZero = matrix[0].any { it == 0 }
        var firstColumnZero = matrix.any { it[0] == 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0
        if (firstRowZero) matrix[0].fill(0)
        if (firstColumnZero) for (row in matrix) row[0] = 0
    }
}
`,cpp:`class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        bool firstRowZero = false, firstColumnZero = false;
        for (int value : matrix[0]) if (value == 0) firstRowZero = true;
        for (const auto& row : matrix) if (row[0] == 0) firstColumnZero = true;
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) fill(matrix[0].begin(), matrix[0].end(), 0);
        if (firstColumnZero) for (auto& row : matrix) row[0] = 0;
    }
};
`}}],w={id:73,slug:o,titleEn:r,difficulty:"中等",category:i,officialTags:t,paidOnly:!1,sourceUrl:n,title:m,studyTags:l,summary:a,insight:e,pitfalls:s,solutions:f};export{i as category,w as default,u as difficulty,c as id,e as insight,t as officialTags,x as paidOnly,s as pitfalls,o as slug,f as solutions,n as sourceUrl,l as studyTags,a as summary,m as title,r as titleEn};
