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
    public int minimumHammingDistance(int[] source,int[] target,int[][] allowedSwaps){
        DSU dsu=new DSU(source.length);
        for(int[] edge:allowedSwaps)dsu.union(edge[0],edge[1]);
        Map<Integer,Map<Integer,Integer>> difference=new HashMap<>();
        for(int i=0;i<source.length;i++){
            Map<Integer,Integer> counts=difference.computeIfAbsent(dsu.find(i),key->new HashMap<>());
            counts.put(source[i],counts.getOrDefault(source[i],0)+1);
            counts.put(target[i],counts.getOrDefault(target[i],0)-1);
        }
        int answer=0;
        for(Map<Integer,Integer> counts:difference.values())for(int count:counts.values())if(count>0)answer+=count;
        return answer;
    }
}
