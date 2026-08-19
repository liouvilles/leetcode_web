class Solution {
    int rows,columns,best;
    vector<int> heights;
    void dfs(int used){
        if(used>=best)return;
        int minimum=rows,start=-1;
        for(int i=0;i<columns;++i)if(heights[i]<minimum){
            minimum=heights[i];
            start=i;
        }
        if(minimum==rows){
            best=used;
            return;
        }
        int width=0;
        while(start+width<columns&&heights[start+width]==minimum)++width;
        int maximum=min(width,rows-minimum);
        for(int size=maximum;size>=1;--size){
            for(int i=0;i<size;++i)heights[start+i]+=size;
            dfs(used+1);
            for(int i=0;i<size;++i)heights[start+i]-=size;
        }
    }
    public:int tilingRectangle(int n,int m){
        rows=max(n,m);
        columns=min(n,m);
        heights.assign(columns,0);
        best=rows*columns;
        dfs(0);
        return best;
    }
};
