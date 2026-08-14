class Solution { fun smallestRepunitDivByK(k:Int):Int{if(k%2==0||k%5==0)return -1;var remainder=0;for(length in 1..k){remainder=(remainder*10+1)%k;if(remainder==0)return length};return -1} }
