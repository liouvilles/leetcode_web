class Solution {
    private int[] positions(int k,int[][] conditions){
        List<Integer>[] graph=new List[k+1];
        for(int i=1;i<=k;i++)graph[i]=new ArrayList<>();
        int[] indegree=new int[k+1];
        for(int[] edge:conditions){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int value=1;value<=k;value++)if(indegree[value]==0)queue.add(value);
        int[] position=new int[k+1];
        int count=0;
        while(!queue.isEmpty()){
            int value=queue.poll();
            position[value]=count++;
            for(int next:graph[value])if(--indegree[next]==0)queue.add(next);
        }
        return count==k?position:null;
    }
    public int[][] buildMatrix(int k,int[][] rowConditions,int[][] colConditions){
        int[] rows=positions(k,rowConditions),columns=positions(k,colConditions);
        if(rows==null||columns==null)return new int[0][0];
        int[][] answer=new int[k][k];
        for(int value=1;value<=k;value++)answer[rows[value]][columns[value]]=value;
        return answer;
    }
}
