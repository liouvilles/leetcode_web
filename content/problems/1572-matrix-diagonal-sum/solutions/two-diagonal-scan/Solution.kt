class Solution { fun diagonalSum(mat:Array<IntArray>):Int{val n=mat.size;var answer=0;for(row in 0 until n)answer+=mat[row][row]+mat[row][n-1-row];if(n%2==1)answer-=mat[n/2][n/2];return answer} }
