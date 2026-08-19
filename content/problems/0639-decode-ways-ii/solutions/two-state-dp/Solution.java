class Solution {
    public int numDecodings(String s){
        long mod=1000000007L,previousTwo=1,previousOne=single(s.charAt(0));
        for(int i=1;i<s.length();i++){
            long current=(single(s.charAt(i))*previousOne+pair(s.charAt(i-1),s.charAt(i))*previousTwo)%mod;
            previousTwo=previousOne;
            previousOne=current;
        }
        return(int)previousOne;
    }
    private int single(char c){
        return c=='*'?9:c=='0'?0:1;
    }
    private int pair(char a,char b){
        if(a=='*')return b=='*'?15:b<='6'?2:1;
        if(a=='1')return b=='*'?9:1;
        if(a=='2')return b=='*'?6:b<='6'?1:0;
        return 0;
    }
}
