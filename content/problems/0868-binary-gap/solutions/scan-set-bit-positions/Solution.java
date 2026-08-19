class Solution {
    public int binaryGap(int n){
        int answer=0,previous=-1,position=0;
        while(n>0){
            if((n&1)==1){
                if(previous>=0)answer=Math.max(answer,position-previous);
                previous=position;
            }
            n>>=1;
            position++;
        }
        return answer;
    }
}
