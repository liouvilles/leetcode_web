class Solution {
    private static class UnionFind{
        int[] parent,size;
        UnionFind(int n){parent=new int[n];size=new int[n];for(int node=0;node<n;node++){parent[node]=node;size[node]=1;}}
        int find(int node){if(parent[node]!=node)parent[node]=find(parent[node]);return parent[node];}
        void union(int first,int second){int a=find(first),b=find(second);if(a==b)return;if(size[a]<size[b]){int temporary=a;a=b;b=temporary;}parent[b]=a;size[a]+=size[b];}
    }
    public int[] minimumCost(int n,int[][] edges,int[][] query){
        UnionFind unionFind=new UnionFind(n);
        for(int[] edge:edges)unionFind.union(edge[0],edge[1]);
        int[] componentCost=new int[n];
        Arrays.fill(componentCost,-1);
        for(int[] edge:edges){int root=unionFind.find(edge[0]);componentCost[root]&=edge[2];}
        int[] answer=new int[query.length];
        for(int index=0;index<query.length;index++){
            int first=unionFind.find(query[index][0]),second=unionFind.find(query[index][1]);
            answer[index]=first==second?componentCost[first]:-1;
        }
        return answer;
    }
}
