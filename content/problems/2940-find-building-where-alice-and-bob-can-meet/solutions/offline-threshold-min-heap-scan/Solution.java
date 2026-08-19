class Solution {
    public int[] leftmostBuildingQueries(int[] heights,int[][] queries){
        List<int[]>[] waiting=new List[heights.length];
        for(int i=0;i<heights.length;i++)waiting[i]=new ArrayList<>();
        int[] answer=new int[queries.length];
        Arrays.fill(answer,-1);
        for(int index=0;index<queries.length;index++){
            int left=Math.min(queries[index][0],queries[index][1]),right=Math.max(queries[index][0],queries[index][1]);
            if(left==right||heights[left]<heights[right])answer[index]=right;
            else waiting[right].add(new int[]{
                heights[left],index
            });
        }
        PriorityQueue<int[]> pending=new PriorityQueue<>((first,second)->Integer.compare(first[0],second[0]));
        for(int building=0;building<heights.length;building++){
            while(!pending.isEmpty()&&pending.peek()[0]<heights[building]){
                int[] query=pending.poll();
                answer[query[1]]=building;
            }
            for(int[] query:waiting[building])pending.add(query);
        }
        return answer;
    }
}
