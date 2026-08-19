class Solution {
    public int largestPathValue(String colors,int[][] edges){
        int n=colors.length();
        List<Integer>[] graph=new List[n];
        int[] indegree=new int[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        int[][] dp=new int[n][26];
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<n;i++)if(indegree[i]==0){
            dp[i][colors.charAt(i)-'a']=1;
            queue.offer(i);
        }
        int processed=0,answer=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            processed++;
            for(int count:dp[node])answer=Math.max(answer,count);
            for(int next:graph[node]){
                int own=colors.charAt(next)-'a';
                for(int color=0;color<26;color++)dp[next][color]=Math.max(dp[next][color],dp[node][color]+(color==own?1:0));
                if(--indegree[next]==0)queue.offer(next);
            }
        }
        return processed==n?answer:-1;
    }
}
