class Solution { fun minOperations(nInput:Int):Int{var n=nInput;var operations=0;while(n>0){n=if(n and 3==3)n+1 else n-(n and -n);operations++};return operations} }
