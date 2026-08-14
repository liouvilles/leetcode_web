const f=54,t="spiral-matrix",o="Spiral Matrix",p="中等",n="数组与矩阵",r=["数组","矩阵","模拟"],w=!1,i="https://leetcode.cn/problems/spiral-matrix/",a="螺旋矩阵",e=["边界模拟","分层遍历","矩阵"],l="按从左到右、从上到下、从右到左、从下到上的顺序，螺旋返回矩阵中的所有元素。",s="维护尚未访问矩形的四条边，每完成一条边就向内收缩，并在逆向遍历前确认边界仍有效。",m=["单行或单列时不能重复访问","下边和左边遍历前要再次检查边界","结果长度应恰好等于元素总数"],c=[{id:"shrinking-boundaries",title:"四边界收缩",kind:"最优",idea:"循环遍历当前矩形的四条边并逐层向内。",steps:["遍历上边并增加 top","遍历右边并减少 right","边界有效时遍历下边和左边"],complexity:{time:"O(mn)",space:"O(1)"},code:{java:`class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) answer.add(matrix[top][column]);
            top++;
            for (int row = top; row <= bottom; row++) answer.add(matrix[row][right]);
            right--;
            if (top <= bottom) { for (int column = right; column >= left; column--) answer.add(matrix[bottom][column]); bottom--; }
            if (left <= right) { for (int row = bottom; row >= top; row--) answer.add(matrix[row][left]); left++; }
        }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val answer = ArrayList<Int>()
        var top = 0; var bottom = matrix.lastIndex; var left = 0; var right = matrix[0].lastIndex
        while (top <= bottom && left <= right) {
            for (column in left..right) answer.add(matrix[top][column]); top++
            for (row in top..bottom) answer.add(matrix[row][right]); right--
            if (top <= bottom) { for (column in right downTo left) answer.add(matrix[bottom][column]); bottom-- }
            if (left <= right) { for (row in bottom downTo top) answer.add(matrix[row][left]); left++ }
        }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> answer;
        int top = 0, bottom = matrix.size() - 1, left = 0, right = matrix[0].size() - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; ++column) answer.push_back(matrix[top][column]);
            ++top;
            for (int row = top; row <= bottom; ++row) answer.push_back(matrix[row][right]);
            --right;
            if (top <= bottom) { for (int column = right; column >= left; --column) answer.push_back(matrix[bottom][column]); --bottom; }
            if (left <= right) { for (int row = bottom; row >= top; --row) answer.push_back(matrix[row][left]); ++left; }
        }
        return answer;
    }
};
`}}],u={id:54,slug:t,titleEn:o,difficulty:"中等",category:n,officialTags:r,paidOnly:!1,sourceUrl:i,title:a,studyTags:e,summary:l,insight:s,pitfalls:m,solutions:c};export{n as category,u as default,p as difficulty,f as id,s as insight,r as officialTags,w as paidOnly,m as pitfalls,t as slug,c as solutions,i as sourceUrl,e as studyTags,l as summary,a as title,o as titleEn};
