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
        void union(int a,int b){
            a=find(a);
            b=find(b);
            if(a==b)return;
            if(rank[a]<rank[b]){
                int t=a;
                a=b;
                b=t;
            }
            parent[b]=a;
            if(rank[a]==rank[b])rank[a]++;
        }
    }
    public List<Boolean> distanceLimitedPathsExist(int n,int[][] edgeList,int[][] queries){
        Arrays.sort(edgeList,Comparator.comparingInt(edge->edge[2]));
        Integer[] order=new Integer[queries.length];
        for(int i=0;i<order.length;i++)order[i]=i;
        Arrays.sort(order,Comparator.comparingInt(i->queries[i][2]));
        Boolean[] answer=new Boolean[queries.length];
        DSU dsu=new DSU(n);
        int edgeIndex=0;
        for(int queryIndex:order){
            int limit=queries[queryIndex][2];
            while(edgeIndex<edgeList.length&&edgeList[edgeIndex][2]<limit){
                dsu.union(edgeList[edgeIndex][0],edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            answer[queryIndex]=dsu.find(queries[queryIndex][0])==dsu.find(queries[queryIndex][1]);
        }
        return Arrays.asList(answer);
    }
}
