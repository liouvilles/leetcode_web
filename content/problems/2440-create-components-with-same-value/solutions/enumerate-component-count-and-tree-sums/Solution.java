class Solution {
    List<Integer>[] graph;
    int[] nums;
    int target;
    boolean valid;
    private int dfs(int node,int parent){
        int sum=nums[node];
        for(int next:graph[node])if(next!=parent)sum+=dfs(next,node);
        if(sum>target)valid=false;
        return sum==target?0:sum;
    }
    public int componentValue(int[] nums,int[][] edges){
        int n=nums.length,total=Arrays.stream(nums).sum();
        this.nums=nums;
        graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int components=n;components>=1;components--)if(total%components==0){
            target=total/components;
            valid=true;
            if(dfs(0,-1)==0&&valid)return components-1;
        }
        return 0;
    }
}
