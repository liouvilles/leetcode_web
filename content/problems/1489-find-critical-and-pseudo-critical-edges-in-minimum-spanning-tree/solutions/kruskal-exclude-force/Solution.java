class Solution {
    private static class DSU{
        int[] parent,rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++)parent[i]=i;
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
            return true;
        }
    }
    private int n;
    private int[][] edges;
    private long mst(int skip,int force){
        DSU dsu=new DSU(n);
        long weight=0;
        int used=0;
        if(force!=-1)for(int[] edge:edges)if(edge[3]==force){
            if(dsu.union(edge[0],edge[1])){
                weight+=edge[2];
                used++;
            }
            break;
        }
        for(int[] edge:edges){
            if(edge[3]==skip||edge[3]==force)continue;
            if(dsu.union(edge[0],edge[1])){
                weight+=edge[2];
                if(++used==n-1)break;
            }
        }
        return used==n-1?weight:Long.MAX_VALUE/4;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n,int[][] input){
        this.n=n;
        edges=new int[input.length][4];
        for(int i=0;i<input.length;i++)edges[i]=new int[]{
            input[i][0],input[i][1],input[i][2],i
        };
        Arrays.sort(edges,Comparator.comparingInt(edge->edge[2]));
        long base=mst(-1,-1);
        List<Integer> critical=new ArrayList<>(),pseudo=new ArrayList<>();
        for(int index=0;index<input.length;index++)if(mst(index,-1)>base)critical.add(index);
        else if(mst(-1,index)==base)pseudo.add(index);
        return Arrays.asList(critical,pseudo);
    }
}
