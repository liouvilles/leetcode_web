class Solution {
    public int minFlips(String s){
        int n=s.length(),zero=0,one=0,answer=n;
        for(int i=0;i<2*n;i++){
            char value=s.charAt(i%n),expectedZero=i%2==0?'0':'1';
            if(value!=expectedZero)zero++;
            else one++;
            if(i>=n){
                int old=i-n;
                char oldValue=s.charAt(old%n),oldExpected=old%2==0?'0':'1';
                if(oldValue!=oldExpected)zero--;
                else one--;
            }
            if(i>=n-1)answer=Math.min(answer,Math.min(zero,one));
        }
        return answer;
    }
}
