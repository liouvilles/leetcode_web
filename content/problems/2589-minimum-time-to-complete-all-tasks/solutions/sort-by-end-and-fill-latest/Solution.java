class Solution {
    public int findMinimumTime(int[][] tasks){
        Arrays.sort(tasks,Comparator.comparingInt(task->task[1]));
        int maximum=0;
        for(int[] task:tasks)maximum=Math.max(maximum,task[1]);
        boolean[] selected=new boolean[maximum+1];
        int answer=0;
        for(int[] task:tasks){
            int need=task[2];
            for(int time=task[0];time<=task[1];time++)if(selected[time])need--;
            for(int time=task[1];need>0;time--)if(!selected[time]){
                selected[time]=true;
                answer++;
                need--;
            }
        }
        return answer;
    }
}
