class Solution {
    fun hitBricks(grid:Array<IntArray>,hits:Array<IntArray>):IntArray{
        val rows=grid.size;
        val columns=grid[0].size;
        val roof=rows*columns;
        val state=Array(rows){
            grid[it].copyOf()
        };
        for(hit in hits)state[hit[0]][hit[1]]--;
        val dsu=DSU(roof+1);
        for(r in 0 until rows)for(c in 0 until columns)if(state[r][c]==1){
            val id=r*columns+c;
            if(r==0)dsu.union(id,roof);
            if(r>0&&state[r-1][c]==1)dsu.union(id,id-columns);
            if(c>0&&state[r][c-1]==1)dsu.union(id,id-1)
        };
        val answer=IntArray(hits.size);
        val directions=intArrayOf(-1,0,1,0,-1);
        for(i in hits.indices.reversed()){
            val r=hits[i][0];
            val c=hits[i][1];
            state[r][c]++;
            if(state[r][c]!=1)continue;
            val before=dsu.componentSize(roof);
            val id=r*columns+c;
            if(r==0)dsu.union(id,roof);
            for(d in 0 until 4){
                val nr=r+directions[d];
                val nc=c+directions[d+1];
                if(nr in 0 until rows&&nc in 0 until columns&&state[nr][nc]==1)dsu.union(id,nr*columns+nc)
            };
            answer[i]=maxOf(0,dsu.componentSize(roof)-before-1)
        };
        return answer
    };
    private class DSU(n:Int){
        val parent=IntArray(n){
            it
        };
        val size=IntArray(n){
            1
        };
        fun find(input:Int):Int{
            var x=input;
            while(x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x]
            };
            return x
        };
        fun union(first:Int,second:Int){
            var a=find(first);
            var b=find(second);
            if(a==b)return;
            if(size[a]<size[b]){
                val temporary=a;
                a=b;
                b=temporary
            };
            parent[b]=a;
            size[a]+=size[b]
        };
        fun componentSize(x:Int)=size[find(x)]
    }
}
