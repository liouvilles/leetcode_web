class Solution {
    private int find(int[] parent,int node){
        while(parent[node]!=node){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
    private void union(int[] parent,int[] size,int first,int second){
        int a=find(parent,first),b=find(parent,second);
        if(a==b)return;
        if(size[a]<size[b]){
            int swap=a;
            a=b;
            b=swap;
        }
        parent[b]=a;
        size[a]+=size[b];
    }
    public long countPaths(int n,int[][] edges){
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int value=2;value*value<=n;value++)if(prime[value])for(int multiple=value*value;multiple<=n;multiple+=value)prime[multiple]=false;
        List<Integer>[] graph=new List[n+1];
        int[] parent=new int[n+1],size=new int[n+1];
        for(int node=1;node<=n;node++){
            graph[node]=new ArrayList<>();
            parent[node]=node;
            size[node]=1;
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            graph[u].add(v);
            graph[v].add(u);
            if(!prime[u]&&!prime[v])union(parent,size,u,v);
        }
        long answer=0;
        for(int node=2;node<=n;node++)if(prime[node]){
            long connected=0;
            for(int next:graph[node])if(!prime[next]){
                long component=size[find(parent,next)];
                answer+=component*(connected+1);
                connected+=component;
            }
        }
        return answer;
    }
}
