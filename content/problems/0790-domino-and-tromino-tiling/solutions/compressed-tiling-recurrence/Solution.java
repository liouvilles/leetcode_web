class Solution { public int numTilings(int n){if(n==1)return 1;if(n==2)return 2;long a=1,b=1,c=2,mod=1000000007L;for(int i=3;i<=n;i++){long next=(2*c+a)%mod;a=b;b=c;c=next;}return(int)c;} }
