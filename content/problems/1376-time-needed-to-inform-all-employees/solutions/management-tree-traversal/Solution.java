class Solution {
    public int numOfMinutes(int n,int headID,int[] manager,int[] informTime){
        List<Integer>[] children=new List[n];
        for(int i=0;i<n;i++)children[i]=new ArrayList<>();
        for(int employee=0;employee<n;employee++)if(manager[employee]!=-1)children[manager[employee]].add(employee);
        Deque<int[]> stack=new ArrayDeque<>();
        stack.push(new int[]{
            headID,0
        });
        int answer=0;
        while(!stack.isEmpty()){
            int[] state=stack.pop();
            int node=state[0],time=state[1];
            answer=Math.max(answer,time);
            for(int child:children[node])stack.push(new int[]{
                child,time+informTime[node]
            });
        }
        return answer;
    }
}
