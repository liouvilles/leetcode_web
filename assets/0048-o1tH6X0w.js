const u=48,t="rotate-image",o="Rotate Image",w="中等",n="数组与矩阵",r=["数组","数学","矩阵"],f=!1,i="https://leetcode.cn/problems/rotate-image/",l="旋转图像",a=["矩阵原地变换","转置","行反转"],e="把 n×n 矩阵原地顺时针旋转九十度，不能另外创建同规模矩阵。",c="顺时针旋转等价于先沿主对角线转置，再把每一行左右反转。",m=["矩阵必须原地修改","转置时只交换对角线一侧","行反转只遍历到中点"],s=[{id:"transpose-reverse",title:"转置后反转行",kind:"最优",idea:"用两次简单的对称操作完成坐标映射。",steps:["交换 matrix[row][column] 与 matrix[column][row]","遍历每一行","对每行执行左右双指针反转"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) for (int column = row + 1; column < n; column++) { int value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value; }
        for (int[] row : matrix) for (int left = 0, right = n - 1; left < right; left++, right--) { int value = row[left]; row[left] = row[right]; row[right] = value; }
    }
}
`,kotlin:`class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (row in 0 until n) for (column in row + 1 until n) { val value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value }
        for (row in matrix) { var left = 0; var right = n - 1; while (left < right) { val value = row[left]; row[left++] = row[right]; row[right--] = value } }
    }
}
`,cpp:`class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for (int row = 0; row < n; ++row) for (int column = row + 1; column < n; ++column) swap(matrix[row][column], matrix[column][row]);
        for (auto& row : matrix) reverse(row.begin(), row.end());
    }
};
`}}],x={id:48,slug:t,titleEn:o,difficulty:"中等",category:n,officialTags:r,paidOnly:!1,sourceUrl:i,title:l,studyTags:a,summary:e,insight:c,pitfalls:m,solutions:s};export{n as category,x as default,w as difficulty,u as id,c as insight,r as officialTags,f as paidOnly,m as pitfalls,t as slug,s as solutions,i as sourceUrl,a as studyTags,e as summary,l as title,o as titleEn};
