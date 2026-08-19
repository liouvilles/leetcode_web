class Solution {
    public int bestClosingTime(String customers){
        int penalty=0;
        for(char customer:customers.toCharArray())if(customer=='Y')penalty++;
        int bestPenalty=penalty,bestHour=0;
        for(int i=0;i<customers.length();i++){
            penalty+=customers.charAt(i)=='Y'?-1:1;
            if(penalty<bestPenalty){
                bestPenalty=penalty;
                bestHour=i+1;
            }
        }
        return bestHour;
    }
}
