class Solution {
    public int minSessions(int[] tasks,int sessionTime){
        int total=1<<tasks.length,infinity=100;
        int[] sessions=new int[total],used=new int[total];
        Arrays.fill(sessions,infinity);
        sessions[0]=1;
        for(int mask=0;mask<total;mask++)for(int task=0;task<tasks.length;task++)if((mask&(1<<task))==0){
            int next=mask|1<<task,newSessions=sessions[mask],newUsed=used[mask]+tasks[task];
            if(newUsed>sessionTime){
                newSessions++;
                newUsed=tasks[task];
            }
            if(newSessions<sessions[next]||newSessions==sessions[next]&&newUsed<used[next]){
                sessions[next]=newSessions;
                used[next]=newUsed;
            }
        }
        return sessions[total-1];
    }
}
