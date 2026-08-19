class Solution {
    public int maxScoreSightseeingPair(int[] values){
        int bestLeft=values[0],answer=Integer.MIN_VALUE;
        for(int j=1;j<values.length;j++){
            answer=Math.max(answer,bestLeft+values[j]-j);
            bestLeft=Math.max(bestLeft,values[j]+j);
        }
        return answer;
    }
}
