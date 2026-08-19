class Solution {
    fun minProcessingTime(processorTime:List<Int>,tasks:List<Int>):Int{
        val processors=processorTime.sorted();
        val sortedTasks=tasks.sortedDescending();
        var answer=0;
        for(i in processors.indices)answer=maxOf(answer,processors[i]+sortedTasks[4*i]);
        return answer
    }
}
