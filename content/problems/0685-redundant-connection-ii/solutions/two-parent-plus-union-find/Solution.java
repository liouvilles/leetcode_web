class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges){
        int n=edges.length;
        int[] parent=new int[n+1];
        int first=-1,second=-1;
        for(int i=0;i<n;i++){
            int from=edges[i][0],to=edges[i][1];
            if(parent[to]==0)parent[to]=from;
            else{
                first=findEdge(edges,parent[to],to,i);
                second=i;
                break;
            }
        }
        int[] union=new int[n+1];
        for(int i=1;i<=n;i++)union[i]=i;
        for(int i=0;i<n;i++){
            if(i==second)continue;
            int from=edges[i][0],to=edges[i][1];
            int a=find(union,from),b=find(union,to);
            if(a==b)return first>=0?edges[first]:edges[i];
            union[b]=a;
        }
        return edges[second];
    }
    private int findEdge(int[][] edges,int from,int to,int before){
        for(int i=0;i<before;i++)if(edges[i][0]==from&&edges[i][1]==to)return i;
        return -1;
    }
    private int find(int[] parent,int value){
        if(parent[value]!=value)parent[value]=find(parent,parent[value]);
        return parent[value];
    }
}
