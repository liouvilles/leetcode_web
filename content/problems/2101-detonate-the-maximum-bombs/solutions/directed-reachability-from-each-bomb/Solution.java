class Solution {
    public int maximumDetonation(int[][] bombs){
        int n=bombs.length;
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int i=0;i<n;i++)for(int j=0;j<n;j++){
            long dx=(long)bombs[i][0]-bombs[j][0],dy=(long)bombs[i][1]-bombs[j][1];
            if(dx*dx+dy*dy<=(long)bombs[i][2]*bombs[i][2])graph[i].add(j);
        }
        int answer=0;
        for(int start=0;start<n;start++){
            boolean[] visited=new boolean[n];
            Deque<Integer> stack=new ArrayDeque<>();
            stack.push(start);
            visited[start]=true;
            int count=0;
            while(!stack.isEmpty()){
                int node=stack.pop();
                count++;
                for(int next:graph[node])if(!visited[next]){
                    visited[next]=true;
                    stack.push(next);
                }
            }
            answer=Math.max(answer,count);
        }
        return answer;
    }
}
