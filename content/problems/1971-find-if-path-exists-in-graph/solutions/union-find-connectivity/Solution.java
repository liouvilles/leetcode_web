class Solution {
    int[] parent;
    private int find(int value){
        return value==parent[value]?value:(parent[value]=find(parent[value]));
    }
    public boolean validPath(int n,int[][] edges,int source,int destination){
        parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int[] edge:edges)parent[find(edge[0])]=find(edge[1]);
        return find(source)==find(destination);
    }
}
