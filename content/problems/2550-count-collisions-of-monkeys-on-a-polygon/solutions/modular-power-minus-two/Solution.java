class Solution { public int monkeyMove(int n){long mod=1_000_000_007L,base=2,result=1;while(n>0){if((n&1)==1)result=result*base%mod;base=base*base%mod;n>>=1;}return (int)((result-2+mod)%mod);} }
