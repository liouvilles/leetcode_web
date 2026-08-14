const m=240,t="search-a-2d-matrix-ii",n="Search a 2D Matrix II",x="中等",r="数组与矩阵",a=["数组","二分查找","分治","矩阵"],f=!1,e="https://leetcode.cn/problems/search-a-2d-matrix-ii/",i="搜索二维矩阵 II",o=["Z 字形搜索","矩阵单调性","线性消除"],l="矩阵每行从左到右递增、每列从上到下递增，判断目标值是否存在。",s="从右上角开始，当前值过大就左移排除一列，过小就下移排除一行。",c=["该矩阵并非按行整体连续有序","起点应选择右上或左下角","每一步至少排除一整行或一整列"],u=[{id:"top-right-walk",title:"右上角阶梯搜索",kind:"最优",idea:"利用右上角同时是所在行最大候选和所在列最小候选的性质。",steps:["从 row=0、column=n-1 开始","当前值大于目标则左移","当前值小于目标则下移"],complexity:{time:"O(m+n)",space:"O(1)"},code:{java:`class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) { int value = matrix[row][column]; if (value == target) return true; if (value > target) column--; else row++; }
        return false;
    }
}
`,kotlin:`class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0; var column = matrix[0].lastIndex
        while (row < matrix.size && column >= 0) { val value = matrix[row][column]; if (value == target) return true; if (value > target) column-- else row++ }
        return false
    }
}
`,cpp:`class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0, column = matrix[0].size() - 1;
        while (row < (int)matrix.size() && column >= 0) { int value = matrix[row][column]; if (value == target) return true; if (value > target) --column; else ++row; }
        return false;
    }
};
`}}],g={id:240,slug:t,titleEn:n,difficulty:"中等",category:r,officialTags:a,paidOnly:!1,sourceUrl:e,title:i,studyTags:o,summary:l,insight:s,pitfalls:c,solutions:u};export{r as category,g as default,x as difficulty,m as id,s as insight,a as officialTags,f as paidOnly,c as pitfalls,t as slug,u as solutions,e as sourceUrl,o as studyTags,l as summary,i as title,n as titleEn};
