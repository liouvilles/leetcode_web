class Solution {
    private class DSU(n:Int){
        val parent=IntArray(n){
            it
        };
        fun find(value:Int):Int{
            if(parent[value]!=value)parent[value]=find(parent[value]);
            return parent[value]
        };
        fun union(first:Int,second:Int){
            val a=find(first);
            val b=find(second);
            if(a!=b)parent[a]=b
        }
    };
    fun matrixRankTransform(matrix:Array<IntArray>):Array<IntArray>{
        val rows=matrix.size;
        val cols=matrix[0].size;
        val cells=(0 until rows*cols).map{
            intArrayOf(it/cols,it%cols)
        }.sortedBy{
            matrix[it[0]][it[1]]
        };
        val rowRank=IntArray(rows);
        val colRank=IntArray(cols);
        val answer=Array(rows){
            IntArray(cols)
        };
        var start=0;
        while(start<cells.size){
            var end=start;
            val value=matrix[cells[start][0]][cells[start][1]];
            while(end<cells.size&&matrix[cells[end][0]][cells[end][1]]==value)end++;
            val dsu=DSU(rows+cols);
            for(index in start until end)dsu.union(cells[index][0],rows+cells[index][1]);
            val componentRank=mutableMapOf<Int,Int>();
            for(index in start until end){
                val row=cells[index][0];
                val col=cells[index][1];
                val root=dsu.find(row);
                componentRank[root]=maxOf(componentRank[root]?:0,maxOf(rowRank[row],colRank[col])+1)
            };
            for(index in start until end){
                val row=cells[index][0];
                val col=cells[index][1];
                answer[row][col]=componentRank[dsu.find(row)]!!
            };
            for(index in start until end){
                val row=cells[index][0];
                val col=cells[index][1];
                rowRank[row]=maxOf(rowRank[row],answer[row][col]);
                colRank[col]=maxOf(colRank[col],answer[row][col])
            };
            start=end
        };
        return answer
    }
}
