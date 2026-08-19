class Solution {
    public int collectTheCoins(int[] coins,int[][] edges){
        int n=coins.length;
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        int[] degree=new int[n];
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int node=0;node<n;node++)if(degree[node]==1&&coins[node]==0)queue.add(node);
        while(!queue.isEmpty()){
            int node=queue.poll();
            if(degree[node]==0)continue;
            degree[node]=0;
            for(int next:graph[node])if(degree[next]>0){
                degree[next]--;
                if(degree[next]==1&&coins[next]==0)queue.add(next);
            }
        }
        for(int node=0;node<n;node++)if(degree[node]==1)queue.add(node);
        for(int round=0;round<2;round++)for(int size=queue.size();size>0;size--){
            int node=queue.poll();
            if(degree[node]==0)continue;
            degree[node]=0;
            for(int next:graph[node])if(degree[next]>0){
                degree[next]--;
                if(degree[next]==1)queue.add(next);
            }
        }
        int degreeSum=0;
        for(int value:degree)degreeSum+=value;
        return degreeSum;
    }
}
