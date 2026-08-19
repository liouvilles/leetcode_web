class Solution {
    public List<List<Integer>> getAncestors(int n,int[][] edges){
        List<Integer>[] graph=new List[n];
        List<List<Integer>> answer=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
            answer.add(new ArrayList<>());
        }
        for(int[] edge:edges)graph[edge[0]].add(edge[1]);
        for(int source=0;source<n;source++){
            boolean[] seen=new boolean[n];
            Deque<Integer> stack=new ArrayDeque<>(graph[source]);
            while(!stack.isEmpty()){
                int node=stack.pop();
                if(seen[node])continue;
                seen[node]=true;
                answer.get(node).add(source);
                for(int next:graph[node])stack.push(next);
            }
        }
        return answer;
    }
}
