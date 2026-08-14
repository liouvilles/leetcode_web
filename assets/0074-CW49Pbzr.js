const d=74,t="search-a-2d-matrix",e="Search a 2D Matrix",u="中等",l="数组与矩阵",i=["数组","二分查找","矩阵"],f=!1,n="https://leetcode.cn/problems/search-a-2d-matrix/",a="搜索二维矩阵",r=["二维二分","下标映射","整体有序"],s="矩阵每行递增，且下一行首元素大于上一行末元素，判断目标值是否存在。",o="矩阵按行展开后是一个完整升序数组，可把一维中点映射为 row=mid/columns、column=mid%columns。",c=["总元素数量为 rows×columns","一维右边界是总数减一","映射除数必须是列数"],m=[{id:"flattened-binary-search",title:"虚拟展开二分",kind:"最优",idea:"不复制矩阵，只用坐标换算在虚拟一维数组上二分。",steps:["建立 [0,mn-1] 闭区间","把中点换算成行列坐标","根据中点值更新二分边界"],complexity:{time:"O(log(mn))",space:"O(1)"},code:{java:`class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columns = matrix[0].length, left = 0, right = matrix.length * columns - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = matrix[middle / columns][middle % columns];
            if (value == target) return true;
            if (value < target) left = middle + 1; else right = middle - 1;
        }
        return false;
    }
}
`,kotlin:`class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val columns = matrix[0].size
        var left = 0
        var right = matrix.size * columns - 1
        while (left <= right) { val middle = left + (right - left) / 2; val value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1 else right = middle - 1 }
        return false
    }
}
`,cpp:`class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int columns = matrix[0].size(), left = 0, right = matrix.size() * columns - 1;
        while (left <= right) { int middle = left + (right - left) / 2; int value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1; else right = middle - 1; }
        return false;
    }
};
`}}],g={id:74,slug:t,titleEn:e,difficulty:"中等",category:l,officialTags:i,paidOnly:!1,sourceUrl:n,title:a,studyTags:r,summary:s,insight:o,pitfalls:c,solutions:m};export{l as category,g as default,u as difficulty,d as id,o as insight,i as officialTags,f as paidOnly,c as pitfalls,t as slug,m as solutions,n as sourceUrl,r as studyTags,s as summary,a as title,e as titleEn};
