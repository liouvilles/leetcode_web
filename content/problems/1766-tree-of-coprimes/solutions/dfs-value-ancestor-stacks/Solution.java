class Solution {
    private int[] nums,answer;
    private List<Integer>[] graph;
    private Deque<int[]>[] stacks;
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    private void dfs(int node,int parent,int depth){
        int bestDepth=-1;
        for(int value=1;value<=50;value++)if(gcd(nums[node],value)==1&&!stacks[value].isEmpty()&&stacks[value].peekLast()[1]>bestDepth){
            bestDepth=stacks[value].peekLast()[1];
            answer[node]=stacks[value].peekLast()[0];
        }
        stacks[nums[node]].offerLast(new int[]{
            node,depth
        });
        for(int next:graph[node])if(next!=parent)dfs(next,node,depth+1);
        stacks[nums[node]].pollLast();
    }
    public int[] getCoprimes(int[] nums,int[][] edges){
        this.nums=nums;
        answer=new int[nums.length];
        Arrays.fill(answer,-1);
        graph=new List[nums.length];
        stacks=new Deque[51];
        for(int i=0;i<nums.length;i++)graph[i]=new ArrayList<>();
        for(int i=1;i<=50;i++)stacks[i]=new ArrayDeque<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0,-1,0);
        return answer;
    }
}
