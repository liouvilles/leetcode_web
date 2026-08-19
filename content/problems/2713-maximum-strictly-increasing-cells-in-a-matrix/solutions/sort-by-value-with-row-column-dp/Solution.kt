class Solution {
    fun maxIncreasingCells(mat:Array<IntArray>):Int{
        val rows=mat.size;
        val cols=mat[0].size;
        val cells=Array(rows*cols){
            IntArray(3)
        };
        var index=0;
        for(row in 0 until rows)for(col in 0 until cols){
            cells[index++]=intArrayOf(mat[row][col],row,col)
        };
        cells.sortWith(Comparator{
            a,b->a[0].compareTo(b[0])
        });
        val rowBest=IntArray(rows);
        val colBest=IntArray(cols);
        var answer=0;
        var start=0;
        while(start<cells.size){
            var end=start;
            while(end<cells.size&&cells[end][0]==cells[start][0])end++;
            val candidate=IntArray(end-start);
            for(i in start until end){
                val row=cells[i][1];
                val col=cells[i][2];
                candidate[i-start]=1+maxOf(rowBest[row],colBest[col]);
                answer=maxOf(answer,candidate[i-start])
            };
            for(i in start until end){
                val row=cells[i][1];
                val col=cells[i][2];
                val value=candidate[i-start];
                rowBest[row]=maxOf(rowBest[row],value);
                colBest[col]=maxOf(colBest[col],value)
            };
            start=end
        };
        return answer
    }
}
