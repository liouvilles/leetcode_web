class Solution {
    public int minProcessingTime(List<Integer> processorTime,List<Integer> tasks){
        List<Integer> processors=new ArrayList<>(processorTime),sortedTasks=new ArrayList<>(tasks);
        Collections.sort(processors);
        sortedTasks.sort(Collections.reverseOrder());
        int answer=0;
        for(int i=0;i<processors.size();i++)answer=Math.max(answer,processors.get(i)+sortedTasks.get(4*i));
        return answer;
    }
}
