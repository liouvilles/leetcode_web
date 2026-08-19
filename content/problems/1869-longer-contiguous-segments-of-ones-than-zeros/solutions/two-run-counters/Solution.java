class Solution {
    public boolean checkZeroOnes(String s){
        int ones=0,zeros=0,bestOne=0,bestZero=0;
        for(char value:s.toCharArray())if(value=='1'){
            ones++;
            zeros=0;
            bestOne=Math.max(bestOne,ones);
        }else{
            zeros++;
            ones=0;
            bestZero=Math.max(bestZero,zeros);
        }
        return bestOne>bestZero;
    }
}
