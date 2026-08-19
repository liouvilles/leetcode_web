class Solution {
    public long maximumHappinessSum(int[] happiness,int k){
        Arrays.sort(happiness);
        long answer=0;
        for(int selected=0;selected<k;selected++)answer+=Math.max(0L,(long)happiness[happiness.length-1-selected]-selected);
        return answer;
    }
}
