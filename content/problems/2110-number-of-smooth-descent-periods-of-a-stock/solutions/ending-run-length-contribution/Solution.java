class Solution {
    public long getDescentPeriods(int[] prices){
        long answer=1,run=1;
        for(int i=1;i<prices.length;i++){
            run=prices[i]==prices[i-1]-1?run+1:1;
            answer+=run;
        }
        return answer;
    }
}
