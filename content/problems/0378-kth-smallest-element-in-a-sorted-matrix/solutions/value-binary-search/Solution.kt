class Solution {
    fun kthSmallest(matrix:Array<IntArray>,k:Int):Int{
        val n=matrix.size;
        var left=matrix[0][0];
        var right=matrix[n-1][n-1];
        while(left<right){
            val middle=left+((right.toLong()-left)/2).toInt();
            var count=0;
            var row=n-1;
            var column=0;
            while(row>=0&&column<n){
                if(matrix[row][column]<=middle){
                    count+=row+1;
                    column++
                }else row--
            };
            if(count<k)left=middle+1 else right=middle
        };
        return left
    }
}
