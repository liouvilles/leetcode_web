class Solution {
    int[] parent,size;
    private int find(int x){
        while(x!=parent[x]){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }
    private void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b)return;
        if(size[a]<size[b]){
            int t=a;
            a=b;
            b=t;
        }
        parent[b]=a;
        size[a]+=size[b];
    }
    public long countPairs(int n,int[][] edges){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int[] edge:edges)union(edge[0],edge[1]);
        long answer=0,seen=0;
        for(int i=0;i<n;i++)if(find(i)==i){
            answer+=seen*size[i];
            seen+=size[i];
        }
        return answer;
    }
}
