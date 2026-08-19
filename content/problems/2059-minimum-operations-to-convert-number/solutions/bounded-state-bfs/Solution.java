class Solution {
    public int minimumOperations(int[] nums,int start,int goal){
        if(start==goal)return 0;
        boolean[] visited=new boolean[1001];
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(start);
        visited[start]=true;
        int steps=0;
        while(!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                int value=queue.poll();
                for(int num:nums)for(int next:new int[]{
                    value+num,value-num,value^num
                }){
                    if(next==goal)return steps+1;
                    if(next>=0&&next<=1000&&!visited[next]){
                        visited[next]=true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
