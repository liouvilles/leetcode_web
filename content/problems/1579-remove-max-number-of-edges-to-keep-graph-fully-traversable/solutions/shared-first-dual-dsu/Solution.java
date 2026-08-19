class Solution {
    private static class DSU{
        int[] parent,rank;
        int components;
        DSU(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            components=n;
            for(int i=1;i<=n;i++)parent[i]=i;
        }
        int find(int x){
            return parent[x]==x?x:(parent[x]=find(parent[x]));
        }
        boolean union(int a,int b){
            a=find(a);
            b=find(b);
            if(a==b)return false;
            if(rank[a]<rank[b]){
                int t=a;
                a=b;
                b=t;
            }
            parent[b]=a;
            if(rank[a]==rank[b])rank[a]++;
            components--;
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n,int[][] edges){
        DSU alice=new DSU(n),bob=new DSU(n);
        int used=0;
        for(int[] edge:edges)if(edge[0]==3&&alice.union(edge[1],edge[2])){
            bob.union(edge[1],edge[2]);
            used++;
        }
        for(int[] edge:edges)if(edge[0]==1){
            if(alice.union(edge[1],edge[2]))used++;
        }else if(edge[0]==2&&bob.union(edge[1],edge[2]))used++;
        return alice.components==1&&bob.components==1?edges.length-used:-1;
    }
}
