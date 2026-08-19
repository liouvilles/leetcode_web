class Solution {
    public int minimumRounds(int[] tasks){
        Map<Integer,Integer> count=new HashMap<>();
        for(int task:tasks)count.merge(task,1,Integer::sum);
        int answer=0;
        for(int value:count.values()){
            if(value==1)return -1;
            answer+=(value+2)/3;
        }
        return answer;
    }
}
