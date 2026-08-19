class Solution {
    public int countHomogenous(String text){
        final int MOD=1_000_000_007;
        long answer=0,run=0;
        for(int i=0;i<text.length();i++){
            run=i>0&&text.charAt(i)==text.charAt(i-1)?run+1:1;
            answer=(answer+run)%MOD;
        }
        return (int)answer;
    }
}
