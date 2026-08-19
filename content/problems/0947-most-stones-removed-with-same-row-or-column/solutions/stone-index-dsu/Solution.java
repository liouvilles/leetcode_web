class Solution {
    public int removeStones(int[][] stones){
        int n=stones.length;
        int[] parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int i=0;i<n;i++)for(int j=i+1;j<n;j++)if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])union(i,j,parent);
        Set<Integer> roots=new HashSet<>();
        for(int i=0;i<n;i++)roots.add(find(i,parent));
        return n-roots.size();
    }
    private int find(int x,int[] p){
        return p[x]==x?x:(p[x]=find(p[x],p));
    }
    private void union(int a,int b,int[] p){
        a=find(a,p);
        b=find(b,p);
        if(a!=b)p[a]=b;
    }
}
