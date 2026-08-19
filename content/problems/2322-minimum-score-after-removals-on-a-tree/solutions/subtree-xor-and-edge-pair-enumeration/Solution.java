class Solution {
    List<Integer>[] graph;
    int[] nums,tin,tout,xor;
    int timer;
    private void dfs(int node,int parent){
        tin[node]=timer++;
        xor[node]=nums[node];
        for(int next:graph[node])if(next!=parent){
            dfs(next,node);
            xor[node]^=xor[next];
        }
        tout[node]=timer;
    }
    private boolean ancestor(int a,int b){
        return tin[a]<=tin[b]&&tout[b]<=tout[a];
    }
    public int minimumScore(int[] nums,int[][] edges){
        int n=nums.length;
        this.nums=nums;
        graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        tin=new int[n];
        tout=new int[n];
        xor=new int[n];
        dfs(0,-1);
        int answer=Integer.MAX_VALUE,total=xor[0];
        for(int a=1;a<n;a++)for(int b=a+1;b<n;b++){
            int x,y,z;
            if(ancestor(a,b)){
                x=xor[b];
                y=xor[a]^xor[b];
                z=total^xor[a];
            }else if(ancestor(b,a)){
                x=xor[a];
                y=xor[b]^xor[a];
                z=total^xor[b];
            }else{
                x=xor[a];
                y=xor[b];
                z=total^xor[a]^xor[b];
            }
            answer=Math.min(answer,Math.max(x,Math.max(y,z))-Math.min(x,Math.min(y,z)));
        }
        return answer;
    }
}
