class Solution {
    private void addExtreme(List<Long> values,long value){
        values.add(value);
        if(values.size()>5){
            Collections.sort(values);
            values.remove(2);
        }
    }
    public long[] placedCoins(int[][] edges,int[] cost){
        int n=cost.length;
        List<Integer>[] graph=new List[n];
        for(int node=0;node<n;node++)graph[node]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] parent=new int[n],order=new int[n];
        Arrays.fill(parent,-1);
        parent[0]=0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.addLast(0);
        int orderSize=0;
        while(!stack.isEmpty()){
            int node=stack.removeLast();
            order[orderSize++]=node;
            for(int next:graph[node])if(parent[next]==-1){
                parent[next]=node;
                stack.addLast(next);
            }
        }
        int[] subtreeSize=new int[n];
        Arrays.fill(subtreeSize,1);
        long[][] extremes=new long[n][];
        long[] answer=new long[n];
        for(int index=n-1;index>=0;index--){
            int node=order[index];
            List<Long> values=new ArrayList<>(6);
            addExtreme(values,cost[node]);
            for(int next:graph[node])if(parent[next]==node){
                subtreeSize[node]+=subtreeSize[next];
                for(long value:extremes[next])addExtreme(values,value);
            }
            Collections.sort(values);
            extremes[node]=new long[values.size()];
            for(int i=0;i<values.size();i++)extremes[node][i]=values.get(i);
            if(subtreeSize[node]<3)answer[node]=1;
            else{
                int last=values.size()-1;
                long largest=values.get(last)*values.get(last-1)*values.get(last-2);
                long mixed=values.get(0)*values.get(1)*values.get(last);
                answer[node]=Math.max(0L,Math.max(largest,mixed));
            }
        }
        return answer;
    }
}
