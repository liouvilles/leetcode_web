class Solution {
    public long taskSchedulerII(int[] tasks,int space){
        Map<Integer,Long> lastDay=new HashMap<>();
        long day=0;
        for(int task:tasks){
            day++;
            if(lastDay.containsKey(task))day=Math.max(day,lastDay.get(task)+space+1);
            lastDay.put(task,day);
        }
        return day;
    }
}
