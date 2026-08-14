class Solution { fun numTilings(n:Int):Int{if(n==1)return 1;if(n==2)return 2;var a=1L;var b=1L;var c=2L;val mod=1000000007L;for(i in 3..n){val next=(2*c+a)%mod;a=b;b=c;c=next};return c.toInt()} }
