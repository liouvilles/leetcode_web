class Solution {
    public int leastInterval(char[] tasks,int n){
        int[] counts=new int[26];
        for(char task:tasks)counts[task-'A']++;
        int maximum=0,kinds=0;
        for(int count:counts)if(count>maximum){
            maximum=count;
            kinds=1;
        }else if(count==maximum)kinds++;
        return Math.max(tasks.length,(maximum-1)*(n+1)+kinds);
    }
}
