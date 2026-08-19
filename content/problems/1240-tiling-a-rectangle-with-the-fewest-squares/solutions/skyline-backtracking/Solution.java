class Solution {
    private int rows,columns,best;
    private int[] heights;
    public int tilingRectangle(int n,int m){
        rows=Math.max(n,m);
        columns=Math.min(n,m);
        heights=new int[columns];
        best=rows*columns;
        dfs(0);
        return best;
    }
    private void dfs(int used){
        if(used>=best)return;
        int minimum=rows,start=-1;
        for(int i=0;i<columns;i++)if(heights[i]<minimum){
            minimum=heights[i];
            start=i;
        }
        if(minimum==rows){
            best=used;
            return;
        }
        int width=0;
        while(start+width<columns&&heights[start+width]==minimum)width++;
        int maximum=Math.min(width,rows-minimum);
        for(int size=maximum;size>=1;size--){
            for(int i=0;i<size;i++)heights[start+i]+=size;
            dfs(used+1);
            for(int i=0;i<size;i++)heights[start+i]-=size;
        }
    }
}
